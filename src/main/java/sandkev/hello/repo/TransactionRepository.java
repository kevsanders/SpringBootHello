package sandkev.hello.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sandkev.hello.batch.Transaction;
import sandkev.hello.entity.Role;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
