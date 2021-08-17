package hello.hellospring.domain.user;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class UserListResponseDTO {
    private final List<UserVO> userList;
}
