package naztech.app.jesper.repo;

import naztech.app.jesper.model.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserClientRepository extends JpaRepository<UserClient, Long> {
    UserClient findByUsername(String username);
}
