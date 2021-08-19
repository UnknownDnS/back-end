package hello.hellospring.domain.board;

import lombok.Data;

@Data
public class BoardCreateReqDTO {
    private String author;
    private String title;
    private String content;

}
