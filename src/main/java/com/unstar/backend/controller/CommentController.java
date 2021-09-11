package com.unstar.backend.controller;

import com.unstar.backend.domain.entity.Comment;
import com.unstar.backend.dto.response.CommentResponseDto;
import com.unstar.backend.dto.response.RootResponseDto;
import com.unstar.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/board/{board_id}/comment")
    public RootResponseDto<List<CommentResponseDto>> findAllCommentsByBoardId(@PathVariable Long board_id){

        return null;
    }

    @PostMapping("/comment")
    public RootResponseDto<CommentResponseDto> insertComment(Comment comment){

        return null;
    }

    @PutMapping("/comment/{comment_id}")
    public RootResponseDto<CommentResponseDto> updateCommentByBoardId(@PathVariable Long comment_id){

        return null;
    }

    @DeleteMapping("/comment/{comment_id}")
    public Long deleteCommentByCommentId(@PathVariable Long comment_id){

        return null;
    }

}
