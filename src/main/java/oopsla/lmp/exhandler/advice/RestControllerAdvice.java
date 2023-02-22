package oopsla.lmp.exhandler.advice;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.exhandler.MemberJoinErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@org.springframework.web.bind.annotation.RestControllerAdvice(basePackages = {"oopsla.lmp.web.member", "oopsla.lmp.web.board"})
public class RestControllerAdvice {

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(IllegalArgumentException.class) // 이거 지정 안해도 파라미터 보고 예외를 처리
//    public MemberJoinErrorResult illegalExHandler(IllegalArgumentException e) {
//        log.error("[exceptionHandler] ex", e);
//        return new MemberJoinErrorResult("BAD", e.getMessage());
//    }

    @ExceptionHandler
    public ResponseEntity<MemberJoinErrorResult> validationFailHandler(TransactionSystemException e, HttpServletRequest request) {
        Member rejectedMember = new Member(request.getParameter("email"),request.getParameter("password"),request.getParameter("name"));
        MemberJoinErrorResult memberJoinErrorResult = new MemberJoinErrorResult("member-validation-fail","회원가입 폼 검증 오류", rejectedMember);
        return new ResponseEntity(memberJoinErrorResult, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<MemberJoinErrorResult> validationFailHandler(BindException e, HttpServletRequest request) {
        Member rejectedMember = new Member(request.getParameter("email"),request.getParameter("password"),request.getParameter("name"));
        MemberJoinErrorResult memberJoinErrorResult = new MemberJoinErrorResult("member-validation-fail","회원가입 폼 검증 오류", rejectedMember);
        return new ResponseEntity(memberJoinErrorResult, HttpStatus.BAD_REQUEST);
    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler
//    public MemberJoinErrorResult exHandler(Exception e) {
//        log.error("[exceptionHandler] ex", e);
//        return new MemberJoinErrorResult("EX", "내부 오류");
//    }
}
