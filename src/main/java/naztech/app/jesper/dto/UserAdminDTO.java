package naztech.app.jesper.dto;

import lombok.Data;

@Data
public class UserAdminDTO {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String publicId;
    private Boolean isActive;
}