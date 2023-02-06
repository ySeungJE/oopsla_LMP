package oopsla.lmp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import oopsla.lmp.domain.board.Board;
import oopsla.lmp.repository.BoardRepository;
import oopsla.lmp.service.BoardService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/boards")
    public String boards(Model model) {
        model.addAttribute("boards", boardRepository.findAll());
        return "boards";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Board board) {
        boardService.create(board);
        return "board";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute ForUpdate forUpdate) {
        Board searched = boardRepository.findById(forUpdate.getId()).get();
        searched.update(forUpdate.title, forUpdate.content);
        boardService.create(searched);
        return "board";
    }

    //json 은 "기본적으로" 문장 전체를 읽어들인다는 걸 잊지 말자.
    @DeleteMapping("/{boardID}")  // json으로 모든 걸 다 받을수는 없음. 객체 자체를 받는게 아니라면 json은 오히려 불편하다. String이랑 객체 말고는 받을 수 있는게 없어ㅅㅂ 심지어 String도 Json 문장 그대로 가져오는 개 쓰레기임
    public String delete(@PathVariable Long boardID) {
        boardService.delete(boardID);
        return "boards";
    }

    @PostMapping("/searchTitle")
    public String searchByTitle(@RequestParam String searchedText, Model model) {
        List<Board> searched = boardRepository.findAll().stream().filter(board ->
                board.getTitle().contains(searchedText)).collect(Collectors.toList());
        model.addAttribute("searched", searched);
        return "searchedBoard";
    }

    @Component
    @Getter @Setter
    public static class ForUpdate {
        private Long id;
        private String content;
        private String title;
    }

}
