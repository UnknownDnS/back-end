package hello.hellospring.repository;

import hello.hellospring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(@Param("userName") String userName);
    User findByUserPassword(@Param("userPassword") String userPassword);
    User findByUserId(@Param("userId") Long userId);
}
