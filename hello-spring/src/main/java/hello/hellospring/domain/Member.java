package hello.hellospring.domain;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Member {

    private Long id; //대리키
    private String userId; //사용자 아이디
    private String userPasswd; //사용자 패스워드
    private String name; //사용자 이름
    private String auth; //사용자 권한
    private Date creationDate; //생성 날짜
    private Date modificationDate; //수정 날짜

    /**
     * 누락된 열있는지 확인
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
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
}
