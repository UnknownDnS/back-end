package hello.hellospring.domain.user;

import hello.hellospring.domain.common.CommonVO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Table(name = "USER")
@Data
public class User extends CommonVO implements Serializable {

    @Column(nullable = false, unique = true, length = 50)
    private String userId;

    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Builder
    public User(String userId, String userPw, UserRole userRole){
        this.userId = userId;
        this.userPw = userPw;
        this.userRole = userRole;
    }

}