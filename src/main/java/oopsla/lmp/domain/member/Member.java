package oopsla.lmp.domain.member;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    @Size(min = 5)
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


