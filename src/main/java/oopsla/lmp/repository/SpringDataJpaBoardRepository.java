package oopsla.lmp.repository;

import oopsla.lmp.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;


// 인터페이스만 상속을 해줘도 구현체를 만들어서 빈으로 띄워줌
public interface SpringDataJpaBoardRepository extends JpaRepository<Board, Long>, BoardRepository {

}