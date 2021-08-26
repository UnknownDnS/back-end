package hello.hellospring.service;

import hello.hellospring.domain.entity.Board;
import hello.hellospring.dto.request.BoardCreateRequestDto;
import hello.hellospring.dto.response.BoardCreateResponseDto;
import hello.hellospring.dto.response.RootResponseDto;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    Board save(Board board);

    Optional<Board> findByBoardId(Long boardId);

    List<Board> findAll();

    BoardCreateResponseDto createBoard(BoardCreateRequestDto boardCreateRequestDto);
}
