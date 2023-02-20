package oopsla.lmp.domain.member;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Entity
@NoArgsConstructor
@Data
public class Member {

    @Id
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;

    @Builder
    public Member(String id, String password, String name) {
        this.email = id;
        this.password = password;
        this.name = name;
    }

}
