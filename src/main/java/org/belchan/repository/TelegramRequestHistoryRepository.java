package org.belchan.repository;

import org.belchan.entity.TelegramRequestHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TelegramRequestHistoryRepository")
public interface TelegramRequestHistoryRepository extends JpaRepository<TelegramRequestHistory, Long> {
}
