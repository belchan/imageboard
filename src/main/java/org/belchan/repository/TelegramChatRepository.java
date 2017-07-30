package org.belchan.repository;

import org.belchan.entity.TelegramChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TelegramChatRepository")
public interface TelegramChatRepository extends JpaRepository<TelegramChat, Long> {
}
