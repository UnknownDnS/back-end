package hello.hellospring.service.user;

import hello.hellospring.domain.user.SignUpDTO;
import hello.hellospring.domain.user.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User login(User user);
    User signup(final SignUpDTO signUpDTO);
    User createUser(User user);
    Optional<User> findByUserId(String userEmail);
    List<User> findAll();
}