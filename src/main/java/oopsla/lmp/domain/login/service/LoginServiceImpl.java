package oopsla.lmp.domain.login.service;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{
    private final MemberRepository memberRepository;

    @Override
    public Member login(String Id, String password) {
        return memberRepository.findById(Id).filter(m -> m.getPassword().equals(password)).orElse(null);
    }

}
