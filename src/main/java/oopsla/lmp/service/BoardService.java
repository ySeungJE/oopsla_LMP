package oopsla.lmp.service;

import oopsla.lmp.domain.Board;
import oopsla.lmp.domain.Member;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    Board create(Board board);
    Board update(Long board_id, String title, String content);
    void delete(Long board_id);
    Board searchByTitle(String searched_text);
}
