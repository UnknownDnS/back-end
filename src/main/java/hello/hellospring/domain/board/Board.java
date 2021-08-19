package hello.hellospring.domain.board;

import hello.hellospring.domain.common.CommonVO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "BOARD")
@Data
public class Board extends CommonVO implements Serializable {

    @Column
    private String author; //작성자

    @Column
    private Comment comment; //댓글

    @Column
    private String title; //제목

    @Column
    private String content; //내용

}
