package org.belchan.service.telegram;

import org.belchan.ApplicationInfo;
import org.belchan.entity.Board;
import org.belchan.entity.Post;
import org.belchan.service.BoardService;
import org.belchan.service.PostService;
import org.belchan.service.TelegramService;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.List;

import static org.belchan.config.SecretData.*;

@Component
public class BelchanBot extends TelegramLongPollingBot {

    private static final Logger logger = LoggerFactory.getLogger(BelchanBot.class);

    @Autowired
    PostService postService;

    @Autowired
    BoardService boardService;

    @Autowired
    TelegramService telegramService;

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();
            telegramService.storeRequest(chatId, text);
            try {
                String[] strings = text.split("@");
                text = strings[0];
            } catch (Exception ignore) {
                logger.error("SPLIT @ ", ignore);
            }
            switch (text) {
                case "/newposts": {
                    publishNewPosts(chatId, true);
                }
                break;
                case "/sasi": {
                    sendMessage(chatId, "Sasai LALKA!");
                }
                break;
                case "/version": {
                    sendMessage(chatId, ApplicationInfo.getChangeSet());
                }
                break;
                default: {
                    sendMessage(chatId, text);
                }
            }
        }
    }

    private static int countRequests = 17;

    public void publishNewPosts(Long chatId, boolean mandatoryAnswer) {
        List<Post> postsAfter = postService.getPostsAfter(chatId);
        if (postsAfter.size() == 0) {
            if (mandatoryAnswer) {
                sendMessage(chatId, "Ничего нового! T" + countRequests + "T");
            }
        } else {
            postsAfter.forEach(post -> {
                StringBuilder sb = new StringBuilder();
                Board board = boardService.getBoard(post.getBoardid());
                sb.append("\nBoard is /");
                sb.append(board.getName());
                sb.append("/ ");
                sb.append(board.getDesc());
                sb.append("\nPOST № ");
                sb.append(post.getId());
                sb.append("\nSubject  ");
                sb.append(post.getSubject());
                sb.append("\nMessage ");
                sb.append(Jsoup.clean(post.getMessage(), Whitelist.simpleText()));
                sb.append("\nURL : http://belchan.org/");
                sb.append(board.getName());
                sb.append("/res/");
                int id = post.getParentid();
                if (id == 0) {
                    id = post.getId();
                }
                sb.append(id);
                sb.append(".html");
                sendMessage(chatId, sb.toString());
            });
        }
        countRequests++;
    }

    private void sendMessage(Long chatId, String message) {
        logger.info("\n\nTELEGARAM MESSAGE : " + chatId + " " + message);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return tgBotName;
    }

    @Override
    public String getBotToken() {
        return tgBotPass;
    }
}
