package hello.hellospring.repository.user;

import hello.hellospring.domain.user.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
import hello.hellospring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(@Param("name") String name);
    User findByPassword(@Param("password") String password);
    User findByUserId(@Param("userId") String userId);

}

*/
@Repository
public interface UserRepository extends JpaRepository<UserVO, Long> {
    UserVO findByUserIdAndUserPw(String userId, String userPw);
    Optional<UserVO> findByUserId(String userId);
}