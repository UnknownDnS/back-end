package hello.hellospring.domain.user;

import lombok.Data;
import lombok.Getter;

@Data
public class LoginDTO {
    private String userName;
    private String userPw;
}
