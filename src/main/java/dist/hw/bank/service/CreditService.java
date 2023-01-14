package dist.hw.bank.service;

import dist.hw.bank.Repository.ICreditRepository;
import dist.hw.bank.Repository.ICustomerRepository;
import dist.hw.bank.model.Credit;
import dist.hw.bank.model.Customer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CreditService implements ICreditService{

    @Autowired
    ICreditRepository creditRepository;

    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    ICustomerService customerService;

    @Override
    public Credit saveCredit(Credit credit) {
        credit.setDate(LocalDateTime.now());
        return (Credit) creditRepository.save(credit);
    }

    @Override
    public void deleteCredit(long creditId) {
        creditRepository.deleteById(creditId);
    }

    @Override
    public void approvaCredit(long creditId) {
        Credit credit = getCreditById(creditId);
        getCreditById(creditId).setDescription("Onaylandı");
         //credit.setDescription("Krediniz Onaylandı");
        creditRepository.save(credit);
        //credit.ifPresent(credit1 -> credit1.setDescription("Krediniz onaylandı"));
         long amount = credit.getCredit_amount();
      //  credit.ifPresent(credit1 -> credit1.getCredit_amount());
        long customerId = credit.getCustomerId();
        Customer customer =  customerService.getCustomerByid(customerId);
        long balance = (long) customer.getAccount().getBalance();
        customer.getAccount().setBalance(balance+amount);
        customerRepository.save(customer);
        creditRepository.deleteById(creditId);
    }

    @Override
    public List<Credit> getAllCredit() {
        return creditRepository.findAll();
    }

    @Override
    public Credit getCreditById(long creditId) {

       // creditRepository.findById(creditId).orElseThrow().setDescription("deneme");
        return creditRepository.findById(creditId).orElseThrow(() -> new EntityNotFoundException(String.valueOf(creditId)));
    }
}
