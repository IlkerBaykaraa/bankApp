package dist.hw.bank.Repository;

import dist.hw.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAccountRepository extends JpaRepository<Account,Long> {


}
