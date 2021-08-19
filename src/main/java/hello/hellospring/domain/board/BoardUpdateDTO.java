package hello.hellospring.domain.board;

import lombok.Data;
import java.util.Date;

@Data
public class BoardUpdateDTO {
    private Long id;
    private String author;
    private String title;
    private String content;
    private String totalComments;
    private Date createdAt;
    private Date updatedAt;
}
