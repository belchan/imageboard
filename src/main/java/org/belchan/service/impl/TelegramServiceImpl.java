package org.belchan.service.impl;

import org.belchan.entity.Post;
import org.belchan.entity.TelegramChat;
import org.belchan.entity.TelegramRequestHistory;
import org.belchan.repository.TelegramChatRepository;
import org.belchan.repository.TelegramRequestHistoryRepository;
import org.belchan.service.TelegramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TelegramServiceImpl implements TelegramService {

    @Autowired
    TelegramRequestHistoryRepository telegramRequestHistoryRepository;

    @Autowired
    TelegramChatRepository telegramChatRepository;

    private static final Logger logger = LoggerFactory.getLogger(TelegramServiceImpl.class);

    @Override
    public void publlishPostsToChanel(List<Post> posts) {

    }

    @Override
    public void storeRequest(Long chatId, String text) {
        try {
            TelegramChat telegramChat = telegramChatRepository.findOne(chatId);
            if (telegramChat == null) {
                telegramChat = new TelegramChat();
                telegramChat.setId(chatId);
                telegramChat.setCreateTime(LocalDateTime.now());
                telegramChat.setUpdateTime(LocalDateTime.now());
                telegramChat = telegramChatRepository.save(telegramChat);
                logger.debug(telegramChat.toString());
            } else {
                TelegramRequestHistory telegramRequestHistory = new TelegramRequestHistory();
                telegramRequestHistory.setTelegramChat(telegramChat);
                telegramRequestHistory.setText(text);
                telegramRequestHistory.setCreateTime(LocalDateTime.now());
                telegramRequestHistoryRepository.save(telegramRequestHistory);
            }
        } catch (Exception ex) {
            logger.error("Try store telegram request", ex);
        }

    }
}



