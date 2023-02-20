package oopsla.lmp.domain.member.sevice;

import oopsla.lmp.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    String join(Member member);

    Optional<Member> findById(String id);
    void validateDuplicateMember(Member member);

    List<Member> findMembers();

}
