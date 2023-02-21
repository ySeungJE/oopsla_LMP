package oopsla.lmp.exhandler;


import lombok.AllArgsConstructor;
import lombok.Data;
import oopsla.lmp.domain.member.Member;

@Data
@AllArgsConstructor
public class MemberJoinErrorResult {
    private String code;
    private String message;
    private Member rejectedMember;
}
