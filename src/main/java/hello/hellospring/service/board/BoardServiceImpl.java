package hello.hellospring.service.board;

import hello.hellospring.domain.board.Board;
import hello.hellospring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public Board save(Board board){
        return boardRepository.save(board);
    }

    @Override
    public Optional<Board> findByBoardId(Long boardId) {
        return boardRepository.findById(boardId);
    }

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }
}
