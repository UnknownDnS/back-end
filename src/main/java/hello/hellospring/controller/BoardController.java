package hello.hellospring.controller;

import hello.hellospring.domain.board.Board;
import hello.hellospring.domain.board.BoardCreateReqDTO;
import hello.hellospring.service.board.BoardService;
import hello.hellospring.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@Log4j2
@RestController
public class BoardController {

    private final BoardService boardService;

    /*게시판 글 전체 조회*/
    //@DeleteMapping("/api/board/")
    @GetMapping("/")
    public ResponseEntity<List<Board>> findAll(){
        return null;
    }

    /*글 등록*/
    @PostMapping("/")
    public ResponseEntity<APIResponse> create(@RequestBody BoardCreateReqDTO boardCreateReqDTO){
        log.info(boardCreateReqDTO);
        Board board = new Board();
        board.setContent(boardCreateReqDTO.getContent());
        board.setAuthor(boardCreateReqDTO.getAuthor());
        board.setTitle(boardCreateReqDTO.getTitle());
        APIResponse apiRes = new APIResponse();
        Board retBoard = boardService.save(board);

        if( retBoard == null){
            apiRes.setErrorMsg("성공적으로 저장되지 못함");
            apiRes.setResultType("failure");
            apiRes.setData(null);
        }else{
            apiRes.setErrorMsg(null);
            apiRes.setResultType("success");
            apiRes.setData(retBoard);
        }
        return ResponseEntity.ok(apiRes);
    }

    /* 글 수정*/
    @PutMapping("/")
    public ResponseEntity<Board> update(@RequestBody Board board){
        return null;
    }

    /*글 삭제*/
    @DeleteMapping("/{board_id}")
    public ResponseEntity<Board> delete(){
        return null;
    }


}
