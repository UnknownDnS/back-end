package hello.hellospring.domain.board;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class BoardReadDTO {
    private List<Board> boards;
    private Long id;
    private String author;
    private String title;
    private String content;
    private Long totalComments;
    private Date createdAt;
    private Date updatedAt;
}
