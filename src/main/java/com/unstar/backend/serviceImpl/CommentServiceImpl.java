package com.unstar.backend.serviceImpl;

import com.unstar.backend.domain.entity.Comment;
import com.unstar.backend.domain.repository.BoardRepository;
import com.unstar.backend.domain.repository.CommentRepository;
import com.unstar.backend.dto.response.CommentResponseDto;
import com.unstar.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service @Slf4j
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Override
    public List<CommentResponseDto> findAllCommentsByBoardId(Long boardId){
        List<CommentResponseDto> dtoList = new ArrayList<CommentResponseDto>();
        CommentResponseDto commentResponseDto = new CommentResponseDto();
        List<Comment>  comments = boardRepository.findById(boardId).orElse(null).getComments();
        for (Comment comment: comments){
            commentResponseDto.setId(comment.getId());
            commentResponseDto.setContent(comment.getContent());
            commentResponseDto.setUserName(comment.getUserName());
            dtoList.add(commentResponseDto);
        }
        return dtoList;
    }

    @Override
    public CommentResponseDto insertComment(Comment comment){
        CommentResponseDto commentResponseDto = null;
        Comment savedComment=commentRepository.save(comment);
        commentResponseDto.setContent(savedComment.getContent());
        commentResponseDto.setId(savedComment.getId());
        commentResponseDto.setUserName(savedComment.getUserName());
        return commentResponseDto;
    }

    @Override
    public CommentResponseDto updateCommentByBoardId(Long commentId){
        CommentResponseDto commentResponseDto=null;
        Comment comment = commentRepository.findById(commentId).orElse(null);
        commentResponseDto.setContent(comment.getContent());
        commentResponseDto.setId(comment.getId());
        commentResponseDto.setUserName(comment.getUserName());
        return commentResponseDto;
    }

    @Override
    public Long deleteCommentByCommentId(Long commentId){
        try{
            if( commentRepository.findById(commentId).isPresent()) {
                boardRepository.deleteById(commentId);
                return commentId;
            }
            else throw new Exception();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
            return null;
        }catch(Exception e1){
            e1.printStackTrace();
            return null;
        }
    }
}
