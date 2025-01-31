package naztech.app.jesper.dto;

import lombok.Data;

@Data
public class UserClientDTO {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String publicId;
    private String machineIp;
    private Boolean isActive;
    private String profilePic;
}