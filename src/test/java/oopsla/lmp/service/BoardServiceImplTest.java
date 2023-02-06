package oopsla.lmp.service;

import jakarta.transaction.Transactional;
import oopsla.lmp.domain.Board;
import oopsla.lmp.domain.Member;
import oopsla.lmp.repository.BoardRepository;
import oopsla.lmp.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class BoardServiceImplTest {

    @Autowired private BoardRepository boardRepository;
    @Autowired private BoardService boardService;
    @Test
    public void createTest() {
        //given
        Board board = new Board();
        board.setTitle("제목");
        board.setContent("내용내용");
        board.setMemberId("dbstmdwp98");
        //when
        Long created_id = boardService.create(board);

        //then
        System.out.println("created_board = " + boardRepository.findById(created_id).get());
        assertThat(boardRepository.findById(created_id).get().getId()).isEqualTo(created_id);
    }

    @Test
    public void updateTest() {
        //given
        Board board = new Board();
        board.setTitle("제목");
        board.setContent("내용내용");
        board.setMemberId("dbstmdwp98");
        Long created_id = boardService.create(board);
        //when
        String content = "수정된 내용";
        String title = "수정된 제목";

        created_id = boardService.update(created_id, title, content);
        //then
        assertThat(boardRepository.findById(created_id).get().getContent()).isEqualTo(content);
        assertThat(boardRepository.findById(created_id).get().getTitle()).isEqualTo(title);

    }

    @Test
    public void deleteTest() {
        //given
        Board board = new Board();
        board.setTitle("제목");
        board.setContent("내용내용");
        board.setMemberId("dbstmdwp98");
        Long created_id = boardService.create(board);

        //when
        boardService.delete(created_id);

        //then
        assertThrows(NoSuchElementException.class,
                ()-> boardRepository.findById(created_id).get());
    }



}