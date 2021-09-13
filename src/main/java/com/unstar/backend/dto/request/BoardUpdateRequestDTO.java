package com.unstar.backend.dto.request;

import lombok.Data;

@Data
public class BoardUpdateRequestDto {
    private Long id;
    private String title;
    private String content;
}
