package oopsla.lmp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@ToString
@Entity @Getter @Setter
@NoArgsConstructor
public class Member {

    @Id
    private String id;
    private String password;
    private String name;

    @Builder
    public Member(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }
}
