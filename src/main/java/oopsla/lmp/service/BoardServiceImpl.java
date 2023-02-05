package oopsla.lmp.service;

import lombok.RequiredArgsConstructor;
import oopsla.lmp.domain.Board;
import oopsla.lmp.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;
    @Override
    public Long create(Board board) {
        Board savedBoard = boardRepository.save(board);
        return savedBoard.getId();
    }
    @Override
    public Board update(String title, String content) {
        boardRepository.update(title, content);
    }

    @Override
    public void delete(Long board_id) {

    }

    @Override
    public Board searchByTitle(String searched_text) {
        return null;
    }
}
