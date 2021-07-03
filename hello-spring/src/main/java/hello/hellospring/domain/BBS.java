package hello.hellospring.domain;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class BBS {

    private Long bbsId; //대리키
    private String subject; //제목
    private String content; //내용
    private Date creationDate; //작성일자
    private Date modificationDate; //수정일자
    private String writerName; //글쓴이

    /**
     * 누락된 열이 있는지 확인
     */

    public Long getBbsId() {
        return bbsId;
    }

    public void setBbsId(Long bbsId) {
        this.bbsId = bbsId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
}
