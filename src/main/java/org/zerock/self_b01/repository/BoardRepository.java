package org.zerock.self_b01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.self_b01.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
