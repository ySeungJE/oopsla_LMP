package oopsla.lmp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oopsla.lmp.domain.Member;
import oopsla.lmp.repository.MemberRepository;
import oopsla.lmp.service.MemberService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class lmpController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;
    @PostMapping("/members/new")
    public Member createMember (@RequestBody Member member){
        memberService.join(member);
        return member;
    }

    // API는 무조건 Post다 Get으로 하면 오류난다......
    // json을 String으로 받으면 문장 전체를 문자열로 입력해버린다
    @PostMapping("/members/findPassword")
    public String findMemberPassword(@RequestBody String id)  {
        Optional<Member> foundMember = memberService.findPassword(id);
        return foundMember.get().getPassword();
    }

    @GetMapping("/members")
    public List<Member> list() {
        List<Member> members = memberService.findMembers();
        return members;
    }

}
