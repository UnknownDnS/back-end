package com.unstar.backend.controller;

import com.unstar.backend.domain.entity.Comment;
import com.unstar.backend.dto.request.CommentCreateRequestDTO;
import com.unstar.backend.dto.response.CommentResponseDTO;
import com.unstar.backend.dto.response.RootResponseDTO;
import com.unstar.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor @RestController
@RequestMapping("/api")  @Slf4j
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/board/{board_id}/comment")
    public RootResponseDTO<List<CommentResponseDTO>> findAllCommentsByBoardId(@PathVariable Integer board_id){
        log.info("[+] CommentController -> find all comments by board_id:"+board_id);
        List<CommentResponseDTO> commentResponseDTOS = commentService.findAllCommentsByBoardId(board_id);
        return new RootResponseDTO<List<CommentResponseDTO>>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(commentResponseDTOS)
                .build();
    }

    @PostMapping("/comment")
    public RootResponseDTO<CommentResponseDTO> insertComment(@RequestBody CommentCreateRequestDTO requestDTO){
        log.info("[+] CommentController -> insert comment:"+requestDTO);
        CommentResponseDTO commentResponseDto = commentService.insertComment(requestDTO);
        return new RootResponseDTO<CommentResponseDTO>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(commentResponseDto)
                .build();
    }

    @PutMapping("/comment/{comment_id}")
    public RootResponseDTO<CommentResponseDTO> updateCommentByCommentId(@PathVariable Integer comment_id){
        log.info("[+] CommentController -> update comment by comment_id:"+comment_id);
        CommentResponseDTO commentResponseDTO = commentService.updateCommentByCommentId(comment_id);
        return new RootResponseDTO<CommentResponseDTO>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(commentResponseDTO)
                .build();
    }

    @DeleteMapping("/comment/{comment_id}")
    public RootResponseDTO<Integer> deleteCommentByCommentId(@PathVariable Integer commentId){
        log.info("[+] CommentController -> update comment by comment_id:"+commentId);
        Integer deletedCommentId=commentService.deleteCommentByCommentId(commentId);
        return new RootResponseDTO<Integer>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(deletedCommentId)
                .build();
    }
}