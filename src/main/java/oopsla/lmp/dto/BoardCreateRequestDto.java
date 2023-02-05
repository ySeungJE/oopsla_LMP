package oopsla.lmp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import oopsla.lmp.domain.Board;
import oopsla.lmp.domain.Member;
import oopsla.lmp.domain.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class BoardCreateRequestDto {
    private Member member;
    private String title;
    private String content;

    @Builder
    public BoardCreateRequestDto(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
    }

    public Board toEntity() {
        return Board.builder()
                .member(member)
                .title(title)
                .content(content)
                .build();
    }
}