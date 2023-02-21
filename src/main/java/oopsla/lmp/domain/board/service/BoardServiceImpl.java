package oopsla.lmp.domain.board.service;

import lombok.RequiredArgsConstructor;
import oopsla.lmp.domain.board.Board;
import oopsla.lmp.domain.board.repository.BoardRepository;
import oopsla.lmp.web.board.dto.BoardCreateUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public Long update(Long board_id, String title, String content) {
        Board board = boardRepository.findById(board_id).get();
        board.update(title, content);
        return board_id;
    }

    @Override
    @Transactional
    public Board updateBoard(Long board_id, BoardCreateUpdateDto boardCreateUpdateDto) {
        Board board = boardRepository.findById(board_id).get();
        board.update(boardCreateUpdateDto.getTitle(), boardCreateUpdateDto.getContent());
        return board;
    }

    @Override
    public void delete(Long board_id) {
        boardRepository.deleteById(board_id);
    }

    @Override
    public Board searchByTitle(String searchedText) {
        return null;
    }

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Board findById(Long id) {
        return boardRepository.findById(id).get();
    }
}
