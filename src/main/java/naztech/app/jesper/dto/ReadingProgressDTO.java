package naztech.app.jesper.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReadingProgressDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private Integer progressPercentage;
    private LocalDateTime lastReadAt;
}
