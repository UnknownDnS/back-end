package hello.hellospring.service;

import hello.hellospring.domain.Board;
import hello.hellospring.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardService {
    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public Board createBoard(Board board){
        return boardRepository.save(board);
    }



}
