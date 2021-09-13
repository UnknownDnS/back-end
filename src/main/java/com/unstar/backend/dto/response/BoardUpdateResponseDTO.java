package com.unstar.backend.dto.response;

import com.unstar.backend.domain.entity.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardUpdateResponseDTO {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Long totalComments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public BoardUpdateResponseDTO fromEntity(Board board){
        this.setId(board.getId());
        this.setAuthor(board.getAuthor());
        this.setTitle(board.getTitle());
        this.setContent(board.getContent());
        this.setTotalComments(board.getComments().stream().count());
        this.setCreatedAt(board.getCreatedAt());
        this.setUpdatedAt(board.getUpdatedAt());
        return this;
    }

}
