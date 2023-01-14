package dist.hw.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dist.hw.bank.model.Customer;

import java.util.Optional;

@Repository
public interface ICustomerRepository<T> extends JpaRepository<Customer, Long> {
    //Customer findByIdentityNo(String identityNo);
}
