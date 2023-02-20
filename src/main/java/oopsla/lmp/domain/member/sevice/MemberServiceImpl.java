package oopsla.lmp.domain.member.sevice;

import lombok.RequiredArgsConstructor;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.domain.member.repository.MemberRepository;
import oopsla.lmp.web.member.dto.MemberUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return member.getEmail();
    }

    @Override
    public Optional<Member> findByEmail(String id) {
        return memberRepository.findById(id);
    }
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    @Transactional
    public Member update(String email, MemberUpdateDto memberUpdateDto) {
        Member targetMember = memberRepository.findById(email).get();
        targetMember.setName(memberUpdateDto.getName());
        targetMember.setPassword(memberUpdateDto.getPassword());
        return targetMember;
    }

    @Override
    public void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
