package dist.hw.bank.logging;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILogRepository extends JpaRepository<Log,Long> {
    List<Log> findAllByUserId(long id);
}
