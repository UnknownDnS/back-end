package hello.hellospring.controller;

import hello.hellospring.domain.entity.Board;
import hello.hellospring.dto.response.RootResponseDto;
import hello.hellospring.dto.request.BoardCreateRequestDto;
import hello.hellospring.dto.response.BoardCreateResponseDto;
import hello.hellospring.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<List<Board>> findAll() {
        return null;
    }

    /**
     * 글 등록
     *
     * @param boardCreateRequestDto
     * @return
     */
    @PostMapping("/board")
    public RootResponseDto<BoardCreateResponseDto> create(@RequestBody BoardCreateRequestDto boardCreateRequestDto) {
        log.info("[create board]");
        BoardCreateResponseDto dto = boardService.createBoard(boardCreateRequestDto);
        return new RootResponseDto<BoardCreateResponseDto>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(dto)
                .build();
    }

    @PutMapping("/board")
    public ResponseEntity<Board> update(@RequestBody Board board) {
        return null;
    }

    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<Board> delete(@PathVariable Integer boardId) {
        return null;
    }


}
