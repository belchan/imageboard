package org.belchan.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="telegram_request_history")
public class TelegramRequestHistory implements Serializable {
    private static final long serialVersionUID = 20170531L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "telegram_chat_id")
    private TelegramChat telegramChat;

    @Lob
    private String text;

    @Column(name = "create_time")
    private LocalDateTime createTime;
}