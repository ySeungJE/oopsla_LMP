package oopsla.lmp.service;

import lombok.RequiredArgsConstructor;
import oopsla.lmp.domain.Board;
import oopsla.lmp.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    @Override
    public Board create(Board board) {
        Board savedBoard = boardRepository.save(board);
        return savedBoard;
    }
    @Override
    public Board update(Long board_id, String title, String content) {
        Board board = boardRepository.findById(board_id).get();
        return board.update(title, content);
    }

    @Override
    public void delete(Long board_id) {

    }

    @Override
    public Board searchByTitle(String searched_text) {
        return null;
    }
}
