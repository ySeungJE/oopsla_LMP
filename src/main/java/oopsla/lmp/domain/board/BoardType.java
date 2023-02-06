package oopsla.lmp.domain.board;

public enum BoardType {

    NOTICE("공지사항"), GENERAL("자유 게시글");
    private final String description;
    BoardType(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
