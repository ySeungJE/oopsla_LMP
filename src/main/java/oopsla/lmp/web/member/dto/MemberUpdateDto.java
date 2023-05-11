package oopsla.lmp.web.member.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberUpdateDto {
    @NotEmpty
    @Size(min = 5)
    private String password;
    @NotEmpty
    private String name;
}
