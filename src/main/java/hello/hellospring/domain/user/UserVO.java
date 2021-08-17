package hello.hellospring.domain.user;

import hello.hellospring.domain.common.CommonVO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Table(name = "USER")
@Getter
public class UserVO extends CommonVO implements Serializable {

    @Setter
    @Column(nullable = false, unique = true, length = 50)
    private String userId;

    @Setter
    @Column(nullable = false)
    private String userPw;

    @Setter
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Builder
    public UserVO(String userId, String userPw, UserRole userRole){
        this.userId = userId;
        this.userPw = userPw;
        this.userRole = userRole;
    }

}