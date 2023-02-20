package oopsla.lmp.domain.board.service;

import oopsla.lmp.domain.board.Board;

import java.util.List;

public interface BoardService {
    Long create(Board board);
    Board createBoard(Board board);
    Long update(Long board_id, String title, String content);
    void delete(Long board_id);
    Board searchByTitle(String searched_text);
    List<Board> findAll();
    Board findById(Long id);
}
