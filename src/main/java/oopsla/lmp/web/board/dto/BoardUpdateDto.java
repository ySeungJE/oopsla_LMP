package oopsla.lmp.web.board.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Component
@Getter
@Setter
public class BoardUpdateDto {
    private Long id;
    private String content;
    private String title;
}
