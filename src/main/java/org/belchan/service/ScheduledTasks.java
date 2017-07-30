package org.belchan.service;

import org.belchan.service.telegram.BelchanBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    BelchanBot belchanBot;

    @Scheduled(fixedDelay = 60000)
    public void publishNewPosts() {
        belchanBot.publishNewPosts(-205174722L, false);
    }
}