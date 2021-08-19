package hello.hellospring.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hello.hellospring.domain.common.CommonVO;
import hello.hellospring.domain.Authority;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends CommonVO implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column( nullable = false, unique = true, length = 50)
    private String userName;

    @JsonIgnore
    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false, unique = true)
    private String nickName;

    @ManyToMany
    @JoinTable(
            name="user_authority",
            joinColumns = {@JoinColumn(name= "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;
}