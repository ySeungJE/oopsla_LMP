package oopsla.lmp.repository;

import oopsla.lmp.domain.FinalWork;
import oopsla.lmp.domain.board.Board;

import java.util.List;
import java.util.Optional;

public interface FinalWorkRepository {
    FinalWork save(FinalWork finalWork);
    Optional<FinalWork> findByName(String name);
    void deleteByName(String name);
}
