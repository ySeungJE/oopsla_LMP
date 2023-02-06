package oopsla.lmp.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import oopsla.lmp.domain.Board;
import oopsla.lmp.repository.BoardRepository;
import oopsla.lmp.service.BoardService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("/add")
    public Board create(@RequestBody Board board) {
        return boardService.create(board);
    }

    @PostMapping("/update")
    public Board update(@RequestBody ForUpdate forUpdate) {
        log.info("");
        Board searched = boardRepository.findById(2L).get();
        searched.update(forUpdate.title, forUpdate.content);

        return boardService.create(searched);
    }



    @Component
    @Getter @Setter
    public static class ForUpdate {
        private Long id;
        private String content;
        private String title;
    }

}
