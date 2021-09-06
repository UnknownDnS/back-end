package com.unstar.backend.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BoardListAllResponseDto {

    private Long id;
    private String author;
    private String title;
    private String content;
    private Long totalComments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
