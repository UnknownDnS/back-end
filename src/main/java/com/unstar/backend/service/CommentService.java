package com.unstar.backend.service;

import com.unstar.backend.domain.entity.Comment;
import com.unstar.backend.dto.response.CommentResponseDTO;
import java.util.List;

public interface CommentService {
    public List<CommentResponseDTO> findAllCommentsByBoardId(Long boardId);
    public CommentResponseDTO insertComment(Comment comment);
    public CommentResponseDTO updateCommentByCommentId(Long commentId);
    public Long deleteCommentByCommentId(Long comment_id);

}
