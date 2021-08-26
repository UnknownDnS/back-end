package com.unstar.backend.service;

import com.unstar.backend.domain.entity.Board;
import com.unstar.backend.dto.request.BoardCreateRequestDto;
import com.unstar.backend.dto.response.BoardCreateResponseDto;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    Board save(Board board);

    Optional<Board> findByBoardId(Long boardId);

    List<Board> findAll();

    BoardCreateResponseDto createBoard(BoardCreateRequestDto boardCreateRequestDto);
}
