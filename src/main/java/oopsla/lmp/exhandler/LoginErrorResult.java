package oopsla.lmp.exhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.web.login.dto.LoginForm;

@Data
@AllArgsConstructor
public class LoginErrorResult {
    private String code;
    private String message;
}