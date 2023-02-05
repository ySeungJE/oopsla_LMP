package oopsla.lmp.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class BoardFileVO {
    private String memberId;
    private String title;
    private String content;
    private List<MultipartFile> files;
}