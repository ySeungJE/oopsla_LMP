package oopsla.lmp.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "member_id")
    private String member_id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    public Board update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }
    @Builder
    public Board(Long id, String member_id, String title, String content) {
        this.id = id;
        this.member_id = member_id;
        this.title = title;
        this.content = content;
    }
}
