package org.belchan.service;

import org.belchan.entity.Post;

import java.util.List;

public interface TelegramService {
    void publlishPostsToChanel(List<Post> posts);

    void storeRequest(Long chatId, String text);
}
