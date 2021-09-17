package com.unstar.backend.controller;

import com.unstar.backend.dto.request.BoardCreateRequestDTO;
import com.unstar.backend.dto.request.BoardUpdateRequestDTO;
import com.unstar.backend.dto.response.BoardInsertResponseDTO;
import com.unstar.backend.dto.response.BoardResponseDTO;
import com.unstar.backend.dto.response.BoardUpdateResponseDTO;
import com.unstar.backend.dto.response.RootResponseDTO;
import com.unstar.backend.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor @RequestMapping("/api")
@RestController @Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public RootResponseDTO<List<BoardResponseDTO>> findAllBoards() {
        log.info("[+] BoardController -> find all boards by nothing");

        return new RootResponseDTO<List<BoardResponseDTO>>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(boardService.findAll())
                .build();
    }

    @PostMapping("/board")
    public RootResponseDTO<BoardInsertResponseDTO> insertBoard(@RequestBody BoardCreateRequestDTO boardCreateRequestDto) {
        log.info("[+] BoardController -> insert board by board dto:" +boardCreateRequestDto);
        BoardInsertResponseDTO dto = boardService.createBoard(boardCreateRequestDto);
        return new RootResponseDTO<BoardInsertResponseDTO>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(dto)
                .build();
    }

    @PutMapping("/board")
    public RootResponseDTO<BoardUpdateResponseDTO> updateBoard(@RequestBody BoardUpdateRequestDTO boardUpdateRequestDto) {
        log.info("[+] BoardController -> update board by board dto:"+boardUpdateRequestDto);
        BoardUpdateResponseDTO dto = boardService.updateBoard(boardUpdateRequestDto);
        return new RootResponseDTO<BoardUpdateResponseDTO>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(dto)
                .build();
    }

    @DeleteMapping("/board/{boardId}")
    public RootResponseDTO<Integer> deleteBoard(@PathVariable Integer boardId) {
        log.info("[+] BoardController -> delete board by board_id:"+boardId);
        Integer deletedBoardId = boardService.deleteBoard(boardId);
        return new RootResponseDTO<Integer>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(deletedBoardId)
                .build();
    }
}