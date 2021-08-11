package hello.hellospring.repository;

import hello.hellospring.domain.Board;
import hello.hellospring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByName(@Param("board_id") String name);
    Board findByPassword(@Param("") String password);
    Board findByUserId(@Param("userId") String userId);
}
