package oopsla.lmp.repository;

import oopsla.lmp.domain.Board;
import oopsla.lmp.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringDataJapBoardRepositoryTest {
    @Autowired private BoardRepository boardRepository;
    @Autowired private MemberRepository memberRepository;
    @Test
    public void searchMemberTest() {

        Member member = Member.builder().id("dbstmdwp98").name("윤승제").password("awe489sd56").build();
        Member searched = memberRepository.findById("dbstmdwp98").get();
        System.out.println("member = " + member);
        Assertions.assertThat(member).isEqualTo(searched);

    }
    @Test
    public void searchBoardTest() {
        Board board = boardRepository.findById(2L).get();
        System.out.println("board = " + board);
        Assertions.assertThat(board);
    }



}