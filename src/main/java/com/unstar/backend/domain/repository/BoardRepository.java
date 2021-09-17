package com.unstar.backend.domain.repository;

import com.unstar.backend.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query(value = "SELECT b FROM Board AS b WHERE b.isEnable = TRUE ORDER BY b.createdAt DESC")
    public List<Board> findAllCreatedAtDesc();

    public Board findByIdAndIsEnableIsTrue(Integer id);
}
