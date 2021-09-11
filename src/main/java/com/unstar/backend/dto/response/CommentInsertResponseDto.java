package com.unstar.backend.dto.response;

import lombok.Data;

@Data
public class CommentInsertResponseDto {
    private String userName; //글쓴이
    private String content; //댓글 내용

}
