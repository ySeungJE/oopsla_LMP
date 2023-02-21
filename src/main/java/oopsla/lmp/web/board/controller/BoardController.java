package oopsla.lmp.web.board.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oopsla.lmp.domain.board.Board;
import oopsla.lmp.domain.board.service.BoardService;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.web.board.dto.BoardCreateUpdateDto;
import oopsla.lmp.web.board.dto.BoardSearchDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static oopsla.lmp.web.login.controller.LoginController.LOGIN_MEMBER;

@Slf4j
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping
    public List<Board> boards(Model model) {
        return boardService.findAll();
    }

    @PostMapping
    public Board create(@Valid @ModelAttribute BoardCreateUpdateDto createDto, HttpServletRequest request) {
        Member nowUser = (Member) request.getSession().getAttribute(LOGIN_MEMBER);
        return boardService.createBoard(Board.builder()
                .title(createDto.getTitle())
                .content(createDto.getContent())
                .memberId(nowUser.getName()).build());
    }

    @PatchMapping("/{boardId}")
    public Board update(@PathVariable Long boardId, @Valid @ModelAttribute BoardCreateUpdateDto updateDto) {
        return boardService.updateBoard(boardId, updateDto);
    }
    @GetMapping("/{boardId}")
    public Board info(@PathVariable Long boardId) {
        return boardService.findById(boardId);
    }

    //json 은 "기본적으로" 문장 전체를 읽어들인다는 걸 잊지 말자.
    @DeleteMapping("/{boardId}")  // json으로 모든 걸 다 받을수는 없음. 객체 자체를 받는게 아니라면 json은 오히려 불편하다. String이랑 객체 말고는 받을 수 있는게 없어ㅅㅂ 심지어 String도 Json 문장 그대로 가져오는 개 쓰레기임
    public String delete(@PathVariable Long boardId) {
        boardService.delete(boardId);
        return "게시글이 삭제되었습니다.";
    }

    @PostMapping("/searchTitle")
    public List<Board> searchByTitle(@Valid @ModelAttribute BoardSearchDto searchDto) {
        return boardService.findAll().stream().filter(board ->
                board.getTitle().contains(searchDto.getSearchedText())).collect(Collectors.toList());
    }


}
