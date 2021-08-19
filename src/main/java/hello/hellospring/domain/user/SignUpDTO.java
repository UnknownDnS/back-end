package hello.hellospring.domain.user;

import lombok.Data;
import lombok.Getter;

@Data
public class SignUpDTO {
    private String userId;
    private String userPw;
}
