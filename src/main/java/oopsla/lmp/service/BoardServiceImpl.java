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
    public Long create(Board board) {
        Board savedBoard = boardRepository.save(board);
        return savedBoard.getId();
    }
    @Override
    public Long update(Long board_id, String title, String content) {
        Board board = boardRepository.findById(board_id).get();
        board.update(title, content);
        return boardRepository.save(board).getId();
    }

    @Override
    public void delete(Long board_id) {
        boardRepository.deleteById(board_id);
    }

    @Override
    public Board searchByTitle(String searchedText) {
        return null;
    }
}
