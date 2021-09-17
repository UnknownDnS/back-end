package com.unstar.backend.service;

import com.unstar.backend.domain.entity.Board;
import com.unstar.backend.dto.request.BoardCreateRequestDTO;
import com.unstar.backend.dto.request.BoardUpdateRequestDTO;
import com.unstar.backend.dto.response.BoardInsertResponseDTO;
import com.unstar.backend.dto.response.BoardResponseDTO;
import com.unstar.backend.dto.response.BoardUpdateResponseDTO;
import java.util.List;
import java.util.Optional;

public interface BoardService {

    Board save(Board board);

    Optional<com.unstar.backend.domain.entity.Board> findById(Integer boardId);

    List<BoardResponseDTO> findAll();

    BoardInsertResponseDTO createBoard(BoardCreateRequestDTO boardCreateRequestDto);
    BoardUpdateResponseDTO updateBoard(BoardUpdateRequestDTO boardUpdateRequestDto);
    Integer deleteBoard(Integer boardId);
}
