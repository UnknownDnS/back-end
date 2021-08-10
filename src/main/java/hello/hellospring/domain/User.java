package hello.hellospring.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {

    @Id @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@OneToMany(fetch= FetchType.LAZY)
    //@JoinColumn(name="BOARD_ID")
    private Long id; //기본키
    private String userId; //사용자 아이디
    private String password; //사용자 패스워드
    private String name; //사용자 이름

    @Enumerated(EnumType.STRING)
    private UserRole authority; //사용자 권한

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate; //생성 날짜

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate; //수정 날짜
}
