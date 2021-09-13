package com.unstar.backend.dto.request;

import lombok.Data;

@Data
public class BoardUpdateRequestDTO {
    private Long id;
    private String title;
    private String content;
}
