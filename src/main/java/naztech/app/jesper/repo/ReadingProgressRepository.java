package naztech.app.jesper.repo;

import naztech.app.jesper.model.ReadingProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingProgressRepository extends JpaRepository<ReadingProgress, Long> {
}
