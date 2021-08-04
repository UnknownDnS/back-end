package hello.hellospring.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //대리키
    private String userId; //사용자 아이디
    private String userPasswd; //사용자 패스워드
    private String userName; //사용자 이름

    @Enumerated(EnumType.ORDINAL)
    private UserRole userRole; //사용자 권한
    private Date createdAt; //생성 날짜
    private Date modifiedAt; //수정 날짜

    public User(String userId, String userPasswd){
        this.userId= userId;
        this.userPasswd = userPasswd;
    }

}
