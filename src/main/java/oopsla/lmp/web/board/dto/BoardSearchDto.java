package oopsla.lmp.web.board.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BoardSearchDto {
    @NotEmpty
    @Size(min = 3, max = 100)
    private String searchedText;
}
