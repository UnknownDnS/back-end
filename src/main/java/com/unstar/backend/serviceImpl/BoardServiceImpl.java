package com.unstar.backend.serviceImpl;

import com.unstar.backend.domain.entity.Board;
import com.unstar.backend.domain.repository.BoardRepository;
import com.unstar.backend.dto.request.BoardCreateRequestDto;
import com.unstar.backend.dto.response.BoardCreateResponseDto;
import com.unstar.backend.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public Board save(Board board) {
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

    @Override
    public BoardCreateResponseDto createBoard(BoardCreateRequestDto boardCreateRequestDto) {
        Board board = new Board();
        board.setAuthor(boardCreateRequestDto.getAuthor());
        board.setContent(boardCreateRequestDto.getContent());
        board.setTitle(boardCreateRequestDto.getTitle());
        Board savedBoard = boardRepository.save(board);
        BoardCreateResponseDto dto = BoardCreateResponseDto.fromEntity(savedBoard);
        return dto;
    }
}
