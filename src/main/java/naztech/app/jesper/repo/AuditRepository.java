package naztech.app.jesper.repo;

import naztech.app.jesper.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Long> {
}
