package oopsla.lmp.service;

import jakarta.transaction.Transactional;
import oopsla.lmp.domain.board.Board;
import oopsla.lmp.domain.board.service.BoardService;
import oopsla.lmp.domain.board.repository.BoardRepository;
import oopsla.lmp.web.board.dto.BoardCreateUpdateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;

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
        board.setMemberName("dbstmdwp98");
        board.setBoardType(false);
        //when
        Long created_id = boardService.createBoard(board).getId();

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
        board.setMemberName("dbstmdwp98");
        board.setBoardType(false);
        Long created_id = boardService.createBoard(board).getId();
        //when
        String content = "수정된 내용";
        String title = "수정된 제목";

        created_id = boardService.updateBoard(created_id, new BoardCreateUpdateDto(content, title, false)).getId();
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
        board.setMemberName("dbstmdwp98");
        board.setBoardType(false);
        Long created_id = boardService.createBoard(board).getId();

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
        board1.setMemberName("dbstmdwp98");
        board1.setBoardType(false);
        Board board2 = new Board();
        board2.setTitle("샌드위치에 오이는 빼주세요");
        board2.setContent("내용내용");
        board2.setMemberName("dbstmdwp98");
        board2.setBoardType(false);
        Board board3 = new Board();
        board3.setTitle("김밥은 역시 누드김밥");
        board3.setContent("내용내용");
        board3.setMemberName("dbstmdwp98");
        board3.setBoardType(false);
        Long created_id1 = boardService.createBoard(board1).getId();
        Long created_id2 = boardService.createBoard(board2).getId();
        Long created_id3 = boardService.createBoard(board3).getId();

        //when
        String searchedText = "김밥";
        List<Board> result = boardService.searchByTitle(searchedText);
        List<Board> result2 = boardService.findAll();

        assertThat(result2.size()).isEqualTo(3);
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getTitle()).contains(searchedText);
        assertThat(result.get(1).getTitle()).contains(searchedText);

    }
}