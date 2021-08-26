package com.unstar.backend.domain.repository;

import com.unstar.backend.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {


}
