package oopsla.lmp.domain.board.repository;

import oopsla.lmp.domain.board.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);
    Optional<Board> findById(Long id);
    void deleteById(Long id);
    List<Board> findByTitleLikeAndBoardType(String title, Boolean boardType);
    List<Board> findByOrderByBoardTypeDesc();
}



