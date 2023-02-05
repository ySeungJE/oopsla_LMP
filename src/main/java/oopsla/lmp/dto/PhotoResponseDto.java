package oopsla.lmp.dto;

import lombok.Getter;
import oopsla.lmp.domain.Photo;

@Getter
public class PhotoResponseDto {
    private Long fileId;  // 파일 id

    public PhotoResponseDto(Photo entity){
        this.fileId = entity.getId();
    }
}