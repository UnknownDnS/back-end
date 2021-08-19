package hello.hellospring.service.user;

import hello.hellospring.domain.user.LoginDTO;
import hello.hellospring.domain.user.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User login(User user);
    User signup(final LoginDTO loginDTO);
    User createUser(User user);
    Optional<User> findByUserName(String userName);
    List<User> findAll();
}