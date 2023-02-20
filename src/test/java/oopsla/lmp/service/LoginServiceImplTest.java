package oopsla.lmp.service;

import oopsla.lmp.domain.login.service.LoginService;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.domain.member.sevice.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class LoginServiceImplTest {

    @Autowired
    MemberService memberService;
    @Autowired
    LoginService loginService;

    @Test
    void login() {
        //given
        Member member = Member.builder()
                .id("dbstmdwp98")
                .name("윤승제")
                .password("1234").build();
        memberService.join(member);
        //when
        Member user1 = loginService.login(member.getEmail(), member.getPassword());
        Member user2 = loginService.login(member.getEmail(), "5678");
        //then
        assertThat(user1).isEqualTo(member);
        assertThat(user2).isEqualTo(null);
    }
}