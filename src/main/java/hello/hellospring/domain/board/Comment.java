package hello.hellospring.domain.board;

import hello.hellospring.domain.common.CommonVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Table(name = "COMMENT")
@Data
public class Comment extends CommonVO implements Serializable {

    private String userName; //글쓴이
    private String content; //댓글 내용

}
