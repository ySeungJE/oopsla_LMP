package oopsla.lmp.web.board.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class BoardCreateUpdateDto {
    @NotEmpty
    private String content;
    @NotEmpty
    private String title;
    @NonNull // 롬복꺼 NonNull 쓰면 sql 에 not null 설정할 필요 없음
    private Boolean boardType;
}
