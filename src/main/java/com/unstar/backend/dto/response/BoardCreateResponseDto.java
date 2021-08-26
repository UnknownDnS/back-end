package com.unstar.backend.dto.response;

import com.unstar.backend.domain.entity.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardCreateResponseDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public static BoardCreateResponseDto fromEntity(Board board) {
        BoardCreateResponseDto dto = new BoardCreateResponseDto();
        dto.setAuthor(board.getAuthor());
        dto.setContent(board.getContent());
        dto.setTitle(board.getTitle());
        dto.setCreatedAt(board.getCreatedAt());
        return dto;
    }
}
