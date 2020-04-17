package sandkev.hello.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sandkev.hello.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
