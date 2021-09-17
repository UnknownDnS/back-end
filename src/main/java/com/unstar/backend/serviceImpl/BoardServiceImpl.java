package com.unstar.backend.serviceImpl;

import com.unstar.backend.domain.entity.Board;
import com.unstar.backend.domain.repository.BoardRepository;
import com.unstar.backend.dto.request.BoardCreateRequestDTO;
import com.unstar.backend.dto.request.BoardUpdateRequestDTO;
import com.unstar.backend.dto.response.BoardInsertResponseDTO;
import com.unstar.backend.dto.response.BoardResponseDTO;
import com.unstar.backend.dto.response.BoardUpdateResponseDTO;
import com.unstar.backend.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service @Slf4j
@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public Board save(com.unstar.backend.domain.entity.Board board) {
        return boardRepository.save(board);
    }

    @Override
    public Optional<Board> findById(Integer boardId) {
        return boardRepository.findById(boardId);
    }

    @Override
    public List<BoardResponseDTO> findAll() {
        List<BoardResponseDTO> dtoList = new ArrayList<>();
        List<Board> boardList = boardRepository.findAllCreatedAtDesc();
        for (Board board : boardList){
            BoardResponseDTO dto = new BoardResponseDTO();
            dto.setId(board.getId());
            dto.setAuthor(board.getAuthor());
            dto.setTitle(board.getTitle());
            dto.setContent(board.getContent());
            dto.setTotalComments(board.getComments().size());
            dto.setCreatedAt(board.getCreatedAt());
            dto.setUpdatedAt(board.getUpdatedAt());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public BoardInsertResponseDTO createBoard(BoardCreateRequestDTO boardCreateRequestDto) {
        com.unstar.backend.domain.entity.Board board = new com.unstar.backend.domain.entity.Board();
        board.setAuthor(boardCreateRequestDto.getAuthor());
        board.setContent(boardCreateRequestDto.getContent());
        board.setTitle(boardCreateRequestDto.getTitle());
        com.unstar.backend.domain.entity.Board savedBoard = boardRepository.save(board);
        BoardInsertResponseDTO dto = BoardInsertResponseDTO.fromEntity(savedBoard);
        return dto;
    }

    @Override //null exception processing
    public BoardUpdateResponseDTO updateBoard(BoardUpdateRequestDTO boardUpdateRequestDto) {
        com.unstar.backend.domain.entity.Board board = findById(boardUpdateRequestDto.getId()).orElse(null);
        board = boardRepository.save(board);
        return new BoardUpdateResponseDTO().fromEntity(board);
    }

    @Override //exception processing....??
    public Integer deleteBoard(Integer boardId) {
        try{
            if( boardRepository.findById(boardId).isPresent()) {
                boardRepository.deleteById(boardId);
                return boardId;
            }
            else throw new Exception();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
            return null;
        }catch(Exception e1){
            e1.printStackTrace();
            return null;
        }
    }

}
