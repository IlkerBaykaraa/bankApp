package dist.hw.bank.service;

import dist.hw.bank.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    List<Account> getAll();
    Optional<Account> getById(long id);
    Optional<Account> getLogs(long userId);
    void Eft();


}
