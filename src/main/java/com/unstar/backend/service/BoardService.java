package com.unstar.backend.service;

import com.unstar.backend.domain.entity.Board;
import com.unstar.backend.dto.request.BoardCreateRequestDto;
import com.unstar.backend.dto.request.BoardUpdateRequestDto;
import com.unstar.backend.dto.response.BoardCreateResponseDto;
import com.unstar.backend.dto.response.BoardListAllResponseDto;
import com.unstar.backend.dto.response.BoardUpdateResponseDto;
import java.util.List;
import java.util.Optional;

public interface BoardService {

    Board save(Board board);

    Optional<Board> findById(Long boardId);

    List<BoardListAllResponseDto> findAll();

    BoardCreateResponseDto createBoard(BoardCreateRequestDto boardCreateRequestDto);
    BoardUpdateResponseDto updateBoard(BoardUpdateRequestDto boardUpdateRequestDto);
    Long deleteBoard(Long boardId);
}
