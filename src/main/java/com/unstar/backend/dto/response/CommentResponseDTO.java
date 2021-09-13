package com.unstar.backend.dto.response;

import lombok.Data;

@Data
public class CommentResponseDTO {
    private Long id; //고유번호
    private String userName; //글쓴이
    private String content; //댓글 내용
}
