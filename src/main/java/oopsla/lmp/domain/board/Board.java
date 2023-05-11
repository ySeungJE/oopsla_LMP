package oopsla.lmp.domain.board;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import oopsla.lmp.BaseTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "board")
public class Board extends BaseTime {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String memberName;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NonNull
    private Boolean boardType;

    public Board update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }
    @Builder
    public Board(Long id, String memberName, String title, String content, Boolean boardType) {
        this.id = id;
        this.memberName = memberName;
        this.title = title;
        this.content = content;
        this.boardType = boardType;
    }
}

// spring.jpa.hibernate.ddl-auto= 이거 로컬 환경에서만 써야함, 원래 테이블 다 드롭해버리는거
// sql alter 로 not null 설정해주면 기존 게시글들은 다 false 처리됨
// 프로퍼티 추가해줬으면 빌더에 넣어주는거 잊으면 안된다
