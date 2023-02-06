package oopsla.lmp.controller;


import lombok.RequiredArgsConstructor;
import oopsla.lmp.domain.Board;
import oopsla.lmp.repository.BoardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private BoardRepository boardRepository;

    @PostMapping("/add")
    public Board create(@RequestBody Board board) {
        return boardRepository.save(board);
    }
}
