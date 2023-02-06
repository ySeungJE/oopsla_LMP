package oopsla.lmp.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Entity @Getter @Setter
@NoArgsConstructor
@Table(name = "board")
public class Board extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "memberId")
    private String memberId;

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
    public Board(Long id, String memberId, String title, String content) {
        this.id = id;
        this.memberId = memberId;
        this.title = title;
        this.content = content;
    }
}
