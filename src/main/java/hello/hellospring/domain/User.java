package hello.hellospring.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {

    @Id @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name="BOARD_ID")
    private Long userId; //대리키
    private String id; //사용자 아이디
    private String userPassword; //사용자 패스워드
    private String userName; //사용자 이름

    @Enumerated(EnumType.ORDINAL)
    private UserRole userRole; //사용자 권한
    private Date createdAt; //생성 날짜
    private Date modifiedAt; //수정 날짜

    public User(String id, String userPassword){
        this.id= id;
        this.userPassword = userPassword;
    }

}
