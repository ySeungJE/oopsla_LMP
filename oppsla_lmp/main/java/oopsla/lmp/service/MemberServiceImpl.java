package oopsla.lmp.service;

import lombok.RequiredArgsConstructor;
import oopsla.lmp.domain.Member;
import oopsla.lmp.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    @Override
    public String join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public Optional<Member> findPassword(String id) {
        return memberRepository.findById(id);
    }
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    @Override
    public void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
