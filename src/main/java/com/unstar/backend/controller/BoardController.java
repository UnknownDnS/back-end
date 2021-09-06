package com.unstar.backend.controller;

import com.unstar.backend.domain.entity.Board;
import com.unstar.backend.dto.request.BoardCreateRequestDto;
import com.unstar.backend.dto.request.BoardUpdateRequestDto;
import com.unstar.backend.dto.response.BoardCreateResponseDto;
import com.unstar.backend.dto.response.BoardListAllResponseDto;
import com.unstar.backend.dto.response.BoardUpdateResponseDto;
import com.unstar.backend.dto.response.RootResponseDto;
import com.unstar.backend.service.BoardService;
import lombok.RequiredArgsConstructor;
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
    public RootResponseDto<List<BoardListAllResponseDto>> findAll() {
        log.info("[+] find all boards");

        return new RootResponseDto<List<BoardListAllResponseDto>>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(boardService.findAll())
                .build();
    }




    /**
     * 글 등록
     *
     * @param boardCreateRequestDto
     * @return
     */
    @PostMapping("/board")
    public RootResponseDto<BoardCreateResponseDto> create(@RequestBody BoardCreateRequestDto boardCreateRequestDto) {
        log.info("[+] create board");
        BoardCreateResponseDto dto = boardService.createBoard(boardCreateRequestDto);
        return new RootResponseDto<BoardCreateResponseDto>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(dto)
                .build();
    }

    @PutMapping("/board")
    public RootResponseDto<BoardUpdateResponseDto> update(@RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        log.info("[+] update board");
        BoardUpdateResponseDto dto = boardService.updateBoard(boardUpdateRequestDto);
        return new RootResponseDto<BoardUpdateResponseDto>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .build();
    }

    @DeleteMapping("/board/{boardId}")
    public Long delete(@PathVariable Long boardId) {
        log.info("[+] delete board");

        return boardService.deleteBoard(boardId);
    }

}
