package oopsla.lmp.web.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.domain.member.repository.MemberRepository;
import oopsla.lmp.domain.member.sevice.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    @PostMapping("/add")
    public Member createMember (@Valid @ModelAttribute Member member){
        memberService.join(member);
        return member;
    }

    @GetMapping
    public List<Member> list() {
        List<Member> members = memberService.findMembers();
        return members;
    }

}
