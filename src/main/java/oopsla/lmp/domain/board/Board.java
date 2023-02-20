package oopsla.lmp.domain.board;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import oopsla.lmp.BaseTime;

@ToString
@Entity @Getter @Setter
@NoArgsConstructor
@Table(name = "board") // spring.jpa.hibernate.ddl-auto= 이거 로컬 환경에서만 써야함, 원래 테이블 다 드롭해버리는거
public class Board extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String memberId;
    @NotEmpty
    private String title;
    @NotEmpty
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
