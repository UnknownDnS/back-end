package com.unstar.backend.dto.request;

import lombok.Data;

@Data
public class CommentCreateRequestDTO {
    private Integer boardId;
    private String author;
    private String content;
}
