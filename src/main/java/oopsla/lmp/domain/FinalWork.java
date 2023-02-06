package oopsla.lmp.domain;


import jakarta.persistence.*;
import lombok.*;

@ToString
@Entity @Getter @Setter
@NoArgsConstructor
public class FinalWork {
    @Id
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    public FinalWork update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }
    @Builder
    public FinalWork(String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
    }
}
