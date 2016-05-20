package org.belchan.repository;

import org.belchan.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("BoardRepository")
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
