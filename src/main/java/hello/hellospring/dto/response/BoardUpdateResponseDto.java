package hello.hellospring.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BoardUpdateResponseDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private String totalComments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
