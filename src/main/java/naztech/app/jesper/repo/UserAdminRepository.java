package naztech.app.jesper.repo;

import naztech.app.jesper.model.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
    UserAdmin findByUsername(String username);
}