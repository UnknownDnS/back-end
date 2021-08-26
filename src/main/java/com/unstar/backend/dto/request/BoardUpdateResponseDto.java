package com.unstar.backend.dto.request;

import lombok.Data;

@Data
public class BoardUpdateResponseDto {
    private Integer id;
    private String title;
    private String content;
}
