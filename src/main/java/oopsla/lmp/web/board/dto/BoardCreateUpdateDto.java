package oopsla.lmp.web.board.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
public class BoardCreateUpdateDto {
    @NotEmpty
    private String content;
    @NotEmpty
    private String title;
}
