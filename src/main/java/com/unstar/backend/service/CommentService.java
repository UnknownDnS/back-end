package com.unstar.backend.service;

import com.unstar.backend.domain.entity.Comment;
import com.unstar.backend.dto.request.CommentCreateRequestDTO;
import com.unstar.backend.dto.response.CommentResponseDTO;
import java.util.List;

public interface CommentService {
    public List<CommentResponseDTO> findAllCommentsByBoardId(Integer boardId);
    public CommentResponseDTO insertComment(CommentCreateRequestDTO requestDTO);
    public CommentResponseDTO updateCommentByCommentId(Integer commentId);
    public Integer deleteCommentByCommentId(Integer comment_id);

}
