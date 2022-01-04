package com.unstar.backend.serviceImpl;

import com.unstar.backend.domain.entity.Board;
import com.unstar.backend.domain.repository.BoardRepository;
import com.unstar.backend.service.BoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BoardServiceImplTest {

    //@InjectMocks
    @Autowired
    BoardServiceImpl boardService;

    //@Mock
    //BoardRepository boardRepository;

    @Test
    void save() {
        Board board = new Board();
        board.setAuthor("test");
        board.setAuthor("test");
        Board savedBoard = boardService.save(board);

        assertThat(board).isEqualTo(savedBoard);
    }
}