package oopsla.lmp.web.login.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oopsla.lmp.domain.login.service.LoginService;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.web.login.dto.LoginForm;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
    public static final String LOGIN_MEMBER = "loginMember";
    private final LoginService loginService;

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form,
                        HttpServletRequest request) throws IOException {

        Member loginMember = loginService.login(form.getEmail(), form.getPassword());

        if (loginMember == null) {
            throw new IllegalArgumentException();
        }

        HttpSession session = request.getSession();

        session.setAttribute(LOGIN_MEMBER, loginMember);
        return "["+loginMember.getName()+"]님 환영합니다";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "로그아웃 완료";
    }

    @GetMapping("/notLoginUser")
    public void IllegalAccess() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

}
