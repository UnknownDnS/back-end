package hello.hellospring.dto.request;

import lombok.Data;

@Data
public class BoardCreateRequestDto {
    private String author;
    private String title;
    private String content;

}
