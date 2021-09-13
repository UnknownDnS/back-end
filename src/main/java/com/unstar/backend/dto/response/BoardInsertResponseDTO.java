package com.unstar.backend.dto.response;

import com.unstar.backend.domain.entity.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardInsertResponseDTO {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public static BoardInsertResponseDTO fromEntity(Board board) {
        BoardInsertResponseDTO dto = new BoardInsertResponseDTO();
        dto.setAuthor(board.getAuthor());
        dto.setContent(board.getContent());
        dto.setTitle(board.getTitle());
        dto.setCreatedAt(board.getCreatedAt());
        return dto;
    }
}
