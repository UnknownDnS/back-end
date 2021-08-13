package hello.hellospring.domain;

import hello.hellospring.domain.user.UserRole;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

//@Entity
@Data
public class User {



    //@OneToMany(fetch= FetchType.LAZY)
    //@JoinColumn(name="BOARD_PK")
    //private Board board;
    /**
     * Caused by: org.hibernate.AnnotationException:
     * Illegal attempt to map a non collection as a @OneToMany, @ManyToMany or @CollectionOfElements: hello.hellospring.domain.User.id
     */
    //Id @Column(name="USER_PK")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //기본키
    private String userId; //사용자 아이디
    private String password; //사용자 패스워드
    private String name; //사용자 이름

    //@Enumerated(EnumType.STRING)
    private UserRole authority; //사용자 권한

    //@Temporal(TemporalType.TIMESTAMP)
    private Date createdDate; //생성 날짜

    //@Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate; //수정 날짜
}
