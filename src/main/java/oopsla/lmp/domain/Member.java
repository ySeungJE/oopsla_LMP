package oopsla.lmp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Member {

    @Id
    private String id;
    private String password;
    private String name;

}
