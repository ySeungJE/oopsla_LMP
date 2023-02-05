package oopsla.lmp.service;

import oopsla.lmp.domain.Board;
import oopsla.lmp.domain.Member;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    Long create(Board board);
    Board update(Long board_id);
    void delete(Long board_id);
    Board searchByTitle(String searched_text);
}
