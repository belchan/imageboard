package org.belchan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="telegram_chat")
public class TelegramChat implements Serializable {

    @Id
    private Long id;

    @Column(name = "create_time")
    private LocalDateTime createTime;


    @Column(name = "update_time")
    private LocalDateTime updateTime;


}
