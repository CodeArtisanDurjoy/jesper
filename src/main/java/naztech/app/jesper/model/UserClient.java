package naztech.app.jesper.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_client")
public class UserClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String phone;
    private String address;
    @Column(name = "public_id", unique = true, nullable = false)
    private String publicId;
    @Column(name = "machine_ip", unique = true)
    private String machineIp;
    private Boolean isActive;
    @Column(name = "profile_pic")
    private String profilePic;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
