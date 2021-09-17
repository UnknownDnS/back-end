package com.unstar.backend.domain.repository;

import com.unstar.backend.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByBoardIdAndIsEnableIsTrue(Integer boardId);
}
