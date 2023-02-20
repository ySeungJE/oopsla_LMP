package oopsla.lmp.service;

import jakarta.transaction.Transactional;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.domain.member.sevice.MemberService;
import oopsla.lmp.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired private MemberRepository memberRepository;
    @Autowired private MemberService memberService;
    @Test
    public void join_Test() {
        //given
        Member member = new Member();
        member.setEmail("testMember");
        member.setName("윤승제");
        member.setPassword("awe48s9d56");

        //when
        String created_id = memberService.join(member);

        //then
        assertThat(memberRepository.findById(created_id).get().getEmail()).isEqualTo(member.getEmail());
    }

    @Test
    public void findPassword_test() {
        //given
        Member member = new Member();
        member.setEmail("testMember");
        member.setName("김수인");
        member.setPassword("awe489sd56");
        String created_id = memberService.join(member);
        //when
        Optional<Member> foundMember = memberService.findById(member.getEmail());
        //then
        assertThat(foundMember.get().getPassword()).isEqualTo("awe489sd56");
    }

    @Test
    public void validateDuplicateMember_test() {
        //given
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setEmail("testMember");
        member1.setName("윤승제");
        member1.setPassword("awe48s9d56");
        member2.setEmail("testMember");
        member2.setName("윤따이조");
        member2.setPassword("dkanqlqjs");

        //when
        String created_id1 = memberService.join(member1);

        //then
        assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
    }

}