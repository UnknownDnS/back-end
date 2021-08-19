package hello.hellospring.service.board;

import hello.hellospring.domain.board.Board;
import java.util.List;
import java.util.Optional;

public interface BoardService {

    Board save(Board board);
    Optional<Board> findByBoardId(Long boardId);
    List<Board> findAll();
}
