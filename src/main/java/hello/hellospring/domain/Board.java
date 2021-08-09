package hello.hellospring.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Board {

    @Id @Column(name="BOARD_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long boardId; //대리키
    private String subject; //제목
    private String content; //내용
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt; //작성일자
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt; //수정일자
    private String userName; //글쓴이

}
