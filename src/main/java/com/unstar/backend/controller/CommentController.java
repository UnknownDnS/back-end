package com.unstar.backend.controller;

import com.unstar.backend.domain.entity.Comment;
import com.unstar.backend.dto.response.CommentInsertResponseDto;
import com.unstar.backend.dto.response.RootResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class CommentController {

    @GetMapping("/board/{board_id}/comment")
    public RootResponseDto<List<Comment>> findAllCommentsByBoardId(@PathVariable Long board_id){

        return null;
    }

    @PostMapping("/comment")
    public RootResponseDto<CommentInsertResponseDto> insertComment(Comment comment){

        return null;
    }

    @PutMapping("/comment/{comment_id}")
    public RootResponseDto<CommentInsertResponseDto> updateCommentByBoardId(@PathVariable Long comment_id){
        return null;
    }

    @DeleteMapping("/comment/{comment_id}")
    public Long deleteCommentByCommentId(@PathVariable Long comment_id){

        return null;
    }

}
