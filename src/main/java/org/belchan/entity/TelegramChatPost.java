package org.belchan.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="telegram_chat_post")
public class TelegramChatPost {
    private static final long serialVersionUID = 20170602L;

    @Id
    @Column(name = "telegram_chat_id")
    private Long id;

//    @Column(name = "telegram_chat_id")
//    private TelegramChat telegramChat;

    private Boolean subscriber;

    @Column(name = "last_check")
    private LocalDateTime lastCheck;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "create_time")
    private LocalDateTime createTime;
}
