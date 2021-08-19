package hello.hellospring.domain.board;

import lombok.Data;
import java.util.Date;

@Data
public class BoardCreateResDTO {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Long totalComments;
    private Date createdAt;
}
