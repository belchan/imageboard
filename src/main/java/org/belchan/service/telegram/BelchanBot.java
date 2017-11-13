package org.belchan.service.telegram;

import org.belchan.ApplicationInfo;
import org.belchan.dto.TelegramConfig;
import org.belchan.entity.Board;
import org.belchan.entity.Post;
import org.belchan.service.BoardService;
import org.belchan.service.PostService;
import org.belchan.service.TelegramService;
import org.belchan.service.email.SendEmail;
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

@Component
public class BelchanBot extends TelegramLongPollingBot {

    private static final Logger logger = LoggerFactory.getLogger(BelchanBot.class);

    @Autowired
    private PostService postService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private TelegramService telegramService;

    @Autowired
    private SendEmail sendEmail;

    @Autowired
    private TelegramConfig telegramConfig;

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();
            telegramService.storeRequest(chatId, text);
            String command = "";
            try {
                String[] messageParts = text.split(" ");
                String[] commandWithBotName = messageParts[0].split("@");
                command = commandWithBotName[0];
            } catch (Exception ignore) {
                logger.error("SPLIT @ ", ignore);
            }
            switch (command) {
                case "/newposts": {
                    publishNewPosts(chatId, true);
                }
                case "/lastposts": {
                    int count = 1;
                    try {
                        String[] strings = text.split(" ", 2);
                        count = Integer.valueOf(strings[1]);
                    } catch (Exception ex) {
                        logger.info(text);
                        ex.printStackTrace();
                    }
                    publishLastPosts(chatId, count);
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
                case "/reply": {
                    try {
                        String[] strings = text.split(" ", 4);
                        postService.addNewPost(strings[1], strings[2], "Anon from Telegram", "", "From telegram", strings[3], "", "", "", update.getUpdateId().toString(), "", chatId.toString(), "");
                        sendMessage(chatId, "Success. Done.");
                    } catch (Exception ignore) {
                        ignore.printStackTrace();
                        sendMessage(chatId, "Fail. Read /help!.");
                    }
                }
                break;
                case "/feedback": {
                    if (text.length() > 3) {
                        sendEmail.send("admin@belchan.org", "FeedBack " + chatId, text);
                        sendMessage(chatId, "TNX.");
                    } else {
                        sendMessage(chatId, "Нужно написать длинное сообщение!!!");
                    }

                }
                break;
                default: {
                    sendMessage(chatId, getHelp());
                }
            }
        }
    }

    private void publishLastPosts(Long chatId, int count) {
        List<Post> latestPosts = postService.getLatestPosts(count);
        sendPostsInChat(chatId, latestPosts);
    }

    private String getHelp() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nHELP :.");
        stringBuilder.append("\nnewposts - Get new posts.");
        stringBuilder.append("\nlastposts - Get last posts. Default 1. Usage : %COUNT%");
        stringBuilder.append("\nversion - Get version of project.");
        stringBuilder.append("\nreply - You can reply to thread with this point. Usage : %BOARD_LETTERS% %THREAD_NUMBER% %MESSAGE%.");
        stringBuilder.append("\nfeedback - Send feedback to developers. Usage : %MESSAGE%");
        return stringBuilder.toString();
    }

    public void publishNewPosts(Long chatId, boolean mandatoryAnswer) {
        List<Post> postsAfter = postService.getPostsAfter(chatId);
        if (postsAfter.size() == 0) {
            if (mandatoryAnswer) {
                sendMessage(chatId, "Ничего нового!");
            }
        } else {
            sendPostsInChat(chatId, postsAfter);
        }
    }

    private void sendPostsInChat(Long chatId, List<Post> postsAfter) {
        StringBuilder sb = new StringBuilder();
        postsAfter.forEach(post -> {
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
            sb.append(".html\n\n");

        });
        sendMessage(chatId, sb.toString());
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
        return telegramConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return telegramConfig.getBotPass();
    }
}
