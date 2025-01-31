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
@Table (name = "audit")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String action;

    @Column(name = "action_timestamp", nullable = false)
    private LocalDateTime actionTimestamp;

    @Column(name = "user_type", nullable = false)
    private String userType;

    @Column(name = "old_data")
    private String oldData;

    @Column(name = "new_data")
    private String newData;
}