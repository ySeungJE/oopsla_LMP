package oopsla.lmp.domain.member.sevice;

import oopsla.lmp.domain.member.Member;
import oopsla.lmp.web.member.dto.MemberUpdateDto;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    String join(Member member);
    Optional<Member> findByEmail(String email);
    void validateDuplicateMember(Member member);
    List<Member> findMembers();
    Member update(String email, MemberUpdateDto memberUpdateDto);
    void delete(String email);
}
