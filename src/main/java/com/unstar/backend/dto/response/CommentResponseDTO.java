package com.unstar.backend.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponseDTO {
    private Integer id; //고유번호
    private String userName; //글쓴이
    private String content; //댓글 내용
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
