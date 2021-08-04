package hello.hellospring.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long boardId; //대리키
    private String subject; //제목
    private String content; //내용
    private Date createdAt; //작성일자
    private Date modifiedAt; //수정일자
    private String userName; //글쓴이


}
