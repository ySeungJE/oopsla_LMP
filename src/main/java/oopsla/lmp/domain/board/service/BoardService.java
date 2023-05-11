package oopsla.lmp.domain.board.service;

import oopsla.lmp.domain.board.Board;
import oopsla.lmp.web.board.dto.BoardCreateUpdateDto;

import java.util.List;

public interface BoardService {
    Board createBoard(Board board);
    Board updateBoard(Long board_id, BoardCreateUpdateDto boardCreateUpdateDto);
    void delete(Long board_id);
    List<Board> searchByTitle(String searched_text);
    List<Board> findAll();
    Board findById(Long id);
}
