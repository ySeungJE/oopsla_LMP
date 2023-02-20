package oopsla.lmp.domain.login.service;

import jakarta.servlet.http.HttpServletRequest;
import oopsla.lmp.domain.member.Member;

public interface LoginService {
    public Member login(String Id, String password);
}
