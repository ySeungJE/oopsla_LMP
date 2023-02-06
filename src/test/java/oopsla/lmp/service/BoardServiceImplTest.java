package oopsla.lmp.service;

import jakarta.transaction.Transactional;
import oopsla.lmp.domain.Board;
import oopsla.lmp.domain.Member;
import oopsla.lmp.repository.BoardRepository;
import oopsla.lmp.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Test
    public void searchByTitleTest() {
        //given
        Board board1 = new Board();
        board1.setTitle("김밥 단무지 맛살 주세요");
        board1.setContent("내용내용");
        board1.setMemberId("dbstmdwp98");
        Board board2 = new Board();
        board2.setTitle("샌드위치에 오이는 빼주세요");
        board2.setContent("내용내용");
        board2.setMemberId("dbstmdwp98");
        Board board3 = new Board();
        board3.setTitle("김밥은 역시 누드김밥");
        board3.setContent("내용내용");
        board3.setMemberId("dbstmdwp98");
        Long created_id1 = boardService.create(board1);
        Long created_id2 = boardService.create(board2);
        Long created_id3 = boardService.create(board3);

        //when
        String searchedText = "김밥";
        List<Board> all = boardRepository.findAll();
        List<Board> searched = all.stream().filter(board ->
                board.getTitle().contains(searchedText)).collect(Collectors.toList());

        assertThat(searched.size()).isEqualTo(2);
        assertThat(searched.get(0).getTitle()).contains(searchedText);
        assertThat(searched.get(1).getTitle()).contains(searchedText);

    }


}