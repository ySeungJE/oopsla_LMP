package oopsla.lmp.domain.board.service;

import oopsla.lmp.domain.board.Board;
import oopsla.lmp.web.board.dto.BoardCreateUpdateDto;

import java.util.List;

public interface BoardService {
    Long create(Board board);
    Board createBoard(Board board);
    Long update(Long board_id, String title, String content); // test 용으로 남겨놓음
    Board updateBoard(Long board_id, BoardCreateUpdateDto boardCreateUpdateDto);
    void delete(Long board_id);
    Board searchByTitle(String searched_text);
    List<Board> findAll();
    Board findById(Long id);
}
