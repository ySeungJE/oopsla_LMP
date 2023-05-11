package oopsla.lmp.exhandler.advice;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.exhandler.BoardCreateErrorResult;
import oopsla.lmp.exhandler.MemberJoinErrorResult;
import oopsla.lmp.exhandler.MemberUpdateErrorResult;
import oopsla.lmp.web.member.dto.MemberUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@org.springframework.web.bind.annotation.RestControllerAdvice(basePackages = {"oopsla.lmp.web.member"})
public class MemberExceptionAdvice {
    @ExceptionHandler
    public ResponseEntity<MemberJoinErrorResult> validationFailHandler(BindException e, HttpServletRequest request) {
        Member rejectedMember = new Member(request.getParameter("email"),request.getParameter("password"),request.getParameter("name"));
        MemberJoinErrorResult memberJoinErrorResult = new MemberJoinErrorResult("member-login-fail","회원가입 폼 검증 오류", rejectedMember);
        return new ResponseEntity(memberJoinErrorResult, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<MemberJoinErrorResult> validationFailHandler(IllegalStateException e, HttpServletRequest request) {
        Member rejectedMember = new Member(request.getParameter("email"),request.getParameter("password"),request.getParameter("name"));
        MemberJoinErrorResult memberJoinErrorResult = new MemberJoinErrorResult("member-login-fail","이미 존재하는 회원입니다", rejectedMember);
        return new ResponseEntity(memberJoinErrorResult, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<MemberJoinErrorResult> validationFailHandler(ConstraintViolationException e, HttpServletRequest request) {
        MemberUpdateDto rejectedMember = new MemberUpdateDto(request.getParameter("password"),request.getParameter("name"));
        MemberUpdateErrorResult memberUpdateErrorResult = new MemberUpdateErrorResult("member-update-fail","회원정보 변경 검증 오류", rejectedMember);
        return new ResponseEntity(memberUpdateErrorResult, HttpStatus.BAD_REQUEST);
    }
}
