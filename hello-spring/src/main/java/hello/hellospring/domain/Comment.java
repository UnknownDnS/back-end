package hello.hellospring.domain;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Comment {

    private String writerName; //글쓴이
    private String content; //댓글 내용
    private Date creationDate; //작성일자
    private Date ModificationDate; //수정일자



}
