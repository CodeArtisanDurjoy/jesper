package naztech.app.jesper.dto;

import lombok.Data;

@Data
public class AuditDTO {
    private Long id;
    private Long userId;
    private String action;
    private String userType;
    private String oldData;
    private String newData;
}
