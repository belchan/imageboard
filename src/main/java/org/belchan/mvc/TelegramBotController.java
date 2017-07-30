package org.belchan.mvc;

import org.belchan.service.PostService;
import org.belchan.service.TelegramService;
import org.belchan.service.telegram.BelchanBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TelegramBotController {

    @Autowired
    PostService postService;

    @Autowired
    TelegramService telegramService;

    @Autowired
    BelchanBot belchanBot;

    @RequestMapping(
            value = {"telegram"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public ResponseEntity findNewPostsAndPublishToTelegram() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
