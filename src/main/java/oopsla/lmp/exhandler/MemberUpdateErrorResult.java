package oopsla.lmp.exhandler;


import lombok.AllArgsConstructor;
import lombok.Data;
import oopsla.lmp.domain.member.Member;
import oopsla.lmp.web.member.dto.MemberUpdateDto;

@Data
@AllArgsConstructor
public class MemberUpdateErrorResult {
    private String code;
    private String message;
    private MemberUpdateDto memberUpdateDto;
}
