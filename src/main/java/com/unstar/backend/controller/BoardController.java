package com.unstar.backend.controller;

import com.unstar.backend.dto.request.BoardCreateRequestDto;
import com.unstar.backend.dto.request.BoardUpdateRequestDto;
import com.unstar.backend.dto.response.BoardInsertResponseDto;
import com.unstar.backend.dto.response.BoardResponseDto;
import com.unstar.backend.dto.response.BoardUpdateResponseDto;
import com.unstar.backend.dto.response.RootResponseDto;
import com.unstar.backend.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public RootResponseDto<List<BoardResponseDto>> findAllBoards() {
        log.info("[+] find all boards");

        return new RootResponseDto<List<BoardResponseDto>>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(boardService.findAll())
                .build();
    }

    @PostMapping("/board")
    public RootResponseDto<BoardInsertResponseDto> insertBoard(@RequestBody BoardCreateRequestDto boardCreateRequestDto) {
        log.info("[+] insert board");
        BoardInsertResponseDto dto = boardService.createBoard(boardCreateRequestDto);
        return new RootResponseDto<BoardInsertResponseDto>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(dto)
                .build();
    }

    @PutMapping("/board")
    public RootResponseDto<BoardUpdateResponseDto> updateBoard(@RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        log.info("[+] update board");
        BoardUpdateResponseDto dto = boardService.updateBoard(boardUpdateRequestDto);
        return new RootResponseDto<BoardUpdateResponseDto>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .build();
    }

    @DeleteMapping("/board/{boardId}")
    public Long deleteBoard(@PathVariable Long boardId) {
        log.info("[+] delete board");
        return boardService.deleteBoard(boardId);
    }

}
