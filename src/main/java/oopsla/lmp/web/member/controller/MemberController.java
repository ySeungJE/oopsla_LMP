package oopsla.lmp.web.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.domain.member.sevice.MemberService;
import oopsla.lmp.web.member.dto.MemberUpdateDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PatchMapping("/{email}")
    public Member update(@PathVariable String email,
                         @ModelAttribute MemberUpdateDto memberUpdateDto) {
        return memberService.update(email, memberUpdateDto);
    }

    @DeleteMapping("/{email}")
    public String delete(@PathVariable String email) {
        memberService.delete(email);
        return "회원 정보가 삭제되었습니다";
    }
}
