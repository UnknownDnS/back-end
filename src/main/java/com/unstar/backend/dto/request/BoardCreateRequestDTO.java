package com.unstar.backend.dto.request;

import lombok.Data;

@Data
public class BoardCreateRequestDTO {
    private String author;
    private String title;
    private String content;

}
