package com.unstar.backend.service;

import com.unstar.backend.dto.request.BoardCreateRequestDto;
import com.unstar.backend.dto.request.BoardUpdateRequestDto;
import com.unstar.backend.dto.response.BoardInsertResponseDto;
import com.unstar.backend.dto.response.BoardResponseDto;
import com.unstar.backend.dto.response.BoardUpdateResponseDto;
import java.util.List;
import java.util.Optional;

public interface BoardService {

    com.unstar.backend.domain.entity.Board save(com.unstar.backend.domain.entity.Board board);

    Optional<com.unstar.backend.domain.entity.Board> findById(Long boardId);

    List<BoardResponseDto> findAll();

    BoardInsertResponseDto createBoard(BoardCreateRequestDto boardCreateRequestDto);
    BoardUpdateResponseDto updateBoard(BoardUpdateRequestDto boardUpdateRequestDto);
    Long deleteBoard(Long boardId);
}
