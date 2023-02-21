package oopsla.lmp.web.member.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemberUpdateDto {
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
}
