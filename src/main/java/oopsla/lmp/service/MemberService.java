package oopsla.lmp.service;

import oopsla.lmp.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    String join(Member member);

    Optional<Member> findPassword(String id);
    void validateDuplicateMember(Member member);

    List<Member> findMembers();
    Member findMemberById(String memberId);
}
