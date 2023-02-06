package oopsla.lmp.service;

import oopsla.lmp.domain.board.Board;

public interface BoardService {
    Long create(Board board);
    Long update(Long board_id, String title, String content);
    void delete(Long board_id);
    Board searchByTitle(String searched_text);
}
