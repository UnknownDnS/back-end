package hello.hellospring.repository;

import hello.hellospring.domain.user.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /*
     * EntityGraph는 쿼리가 수행이 될때 Lazy 조회가 아니고
     * Eager조회로 authorities 정보를 같이 가져옴
     */
    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUserName(String userName);

    //User findByUserNameAndUserPw(String userName, String userPw);
   // Optional<User> findByUserName(String userName);

}