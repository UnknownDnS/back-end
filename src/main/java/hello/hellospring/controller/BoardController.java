package hello.hellospring.controller;

import hello.hellospring.domain.Board;
import hello.hellospring.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller @RequestMapping("/board") @Slf4j
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public  BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping("/create")
    public @ResponseBody Board createBoard(@RequestParam String title,
                                           @RequestParam String content){
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setCreatedAt(new Date());
        return boardService.createBoard(board);
    }

    @GetMapping("/read")
    public @ResponseBody Board readBoard(@RequestParam Long bid){

        return null;
    }




}
