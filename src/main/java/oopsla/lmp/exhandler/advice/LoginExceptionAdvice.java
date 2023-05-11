package oopsla.lmp.exhandler.advice;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.exhandler.LoginErrorResult;
import oopsla.lmp.exhandler.MemberJoinErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@org.springframework.web.bind.annotation.RestControllerAdvice(basePackages = {"oopsla.lmp.web.login"})
public class LoginExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<LoginErrorResult> validationFailHandler(BindException e) {
        LoginErrorResult loginErrorResult = new LoginErrorResult("login-validation-fail","이메일과 비밀번호는 빈 칸일 수 없습니다");
        return new ResponseEntity(loginErrorResult, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<LoginErrorResult> validationFailHandler(IllegalArgumentException e) {
        LoginErrorResult loginErrorResult = new LoginErrorResult("login-validation-fail","이메일 또는 비밀번호가 틀립니다");
        return new ResponseEntity(loginErrorResult, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<LoginErrorResult> validationFailHandler(IllegalAccessException e) {
        LoginErrorResult loginErrorResult = new LoginErrorResult("not-login-user","로그인이 필요합니다");
        return new ResponseEntity(loginErrorResult, HttpStatus.BAD_REQUEST);
    }

}
