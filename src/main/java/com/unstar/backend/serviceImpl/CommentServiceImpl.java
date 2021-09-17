package com.unstar.backend.serviceImpl;

import com.unstar.backend.domain.entity.Board;
import com.unstar.backend.domain.entity.Comment;
import com.unstar.backend.domain.repository.BoardRepository;
import com.unstar.backend.domain.repository.CommentRepository;
import com.unstar.backend.dto.request.CommentCreateRequestDTO;
import com.unstar.backend.dto.response.CommentResponseDTO;
import com.unstar.backend.exception.InvalidRequestParamException;
import com.unstar.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Override
    public List<CommentResponseDTO> findAllCommentsByBoardId(Integer boardId) {
        List<CommentResponseDTO> dtoList = new ArrayList<>();
        List<Comment> comments = commentRepository.findAllByBoardIdAndIsEnableIsTrue(boardId);
        for (Comment comment : comments) {
            CommentResponseDTO commentResponseDto = new CommentResponseDTO();
            commentResponseDto.setId(comment.getId());
            commentResponseDto.setContent(comment.getContent());
            commentResponseDto.setUserName(comment.getUserName());
            commentResponseDto.setCreatedAt(comment.getCreatedAt());
            commentResponseDto.setUpdatedAt(comment.getUpdatedAt());
            dtoList.add(commentResponseDto);
        }
        return dtoList;
    }

    @Override
    public CommentResponseDTO insertComment(CommentCreateRequestDTO requestDto) {
        Board board = boardRepository.findByIdAndIsEnableIsTrue(requestDto.getBoardId());
        if (board == null) {
            throw new InvalidRequestParamException("boardId가 유효하지 않습니다.");
        }
        CommentResponseDTO commentResponseDto = new CommentResponseDTO();
        Comment comment = new Comment();
        comment.setContent(requestDto.getContent());
        comment.setUserName(requestDto.getAuthor());
        comment.setBoard(board);
        Comment savedComment = commentRepository.save(comment);
        commentResponseDto.setContent(savedComment.getContent());
        commentResponseDto.setId(savedComment.getId());
        commentResponseDto.setUserName(savedComment.getUserName());
        commentResponseDto.setCreatedAt(comment.getCreatedAt());
        commentResponseDto.setUpdatedAt(comment.getUpdatedAt());
        return commentResponseDto;
    }

    @Override
    public CommentResponseDTO updateCommentByCommentId(Integer commentId) {
        CommentResponseDTO commentResponseDto = new CommentResponseDTO();
        Comment comment = commentRepository.findById(commentId).orElse(null);
        commentResponseDto.setContent(comment.getContent());
        commentResponseDto.setId(comment.getId());
        commentResponseDto.setUserName(comment.getUserName());
        return commentResponseDto;
    }

    @Override
    public Integer deleteCommentByCommentId(Integer commentId) {
        try {
            if (commentRepository.findById(commentId).isPresent()) {
                boardRepository.deleteById(commentId);
                return commentId;
            } else throw new Exception();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1) {
            e1.printStackTrace();
            return null;
        }
    }
}
