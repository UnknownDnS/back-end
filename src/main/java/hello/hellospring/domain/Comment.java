package hello.hellospring.domain;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

//@Entity
//@Data
public class Comment {
    private String userName; //글쓴이
    private String content; //댓글 내용
    private Date createdDate; //작성일자
    private Date modifiedDate; //수정일자
}
