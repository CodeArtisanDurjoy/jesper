package naztech.app.jesper.dto;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String description;
    private String coverImage;
    private Boolean isAvailable;
}