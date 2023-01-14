package dist.hw.bank.Repository;

import dist.hw.bank.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditRepository extends JpaRepository<Credit,Long> {
}
