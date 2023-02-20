package oopsla.lmp.web.login.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oopsla.lmp.domain.login.service.LoginService;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.web.login.dto.LoginForm;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
    public static final String LOGIN_MEMBER = "loginMember";
    private final LoginService loginService;

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult ,
                          @RequestParam(defaultValue = "/") String redirectURL,
                          HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return bindingResult.toString();
        }

        Member loginMember = loginService.login(form.getId(), form.getPassword());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return bindingResult.toString();
        }

        // 로그인 성공 처리
        //세션 객체가 있으면 있는 세션 객체를 반환, 없으면 신규 세션 객체 생성, 한 객체 안에 많은 세션 정보가 담길 수 있다고 일단 생각하는중
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관, 근데 저렇게 다이렉트로 둘을 연결하는 게 아니라, UUID 를 사용해서 한번 꼬아서 연결하겠지?
        session.setAttribute(LOGIN_MEMBER, loginMember);

        return redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "로그아웃 완료";
    }

}
