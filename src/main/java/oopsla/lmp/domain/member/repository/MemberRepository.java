package oopsla.lmp.domain.member.repository;

import oopsla.lmp.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(String id);
    List<Member> findAll();
    void deleteByEmail(String Email);
}


