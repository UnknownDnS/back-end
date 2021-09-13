package com.unstar.backend.dto.response;

import com.unstar.backend.domain.entity.Board;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class BoardListResponseDto {
    private List<Board> boards;
    private Long id;
    private String author;
    private String title;
    private String content;
    private Integer totalComments;
    private Date createdAt;
    private Date updatedAt;
}
