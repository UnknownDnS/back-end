package com.unstar.backend.service;

import com.unstar.backend.domain.entity.Comment;
import com.unstar.backend.dto.response.CommentResponseDto;
import java.util.List;

public interface CommentService {
    public List<CommentResponseDto> findAllCommentsByBoardId(Long boardId);
    public CommentResponseDto insertComment(Comment comment);
    public CommentResponseDto updateCommentByBoardId(Long commentId);
    public Long deleteCommentByCommentId(Long comment_id);

}
