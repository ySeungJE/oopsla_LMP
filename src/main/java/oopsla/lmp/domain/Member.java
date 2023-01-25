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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
