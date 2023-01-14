package dist.hw.bank.service;

import dist.hw.bank.Repository.IAccountRepository;
import dist.hw.bank.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService{

    @Autowired
    IAccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getById(long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Optional<Account> getLogs(long userId) {
        return accountRepository.findById(userId);
    }

    @Override
    public void Eft() {

    }




}
