package dist.hw.bank.service;

import dist.hw.bank.model.Credit;

import java.util.List;

public interface ICreditService {
    Credit saveCredit (Credit credit);
    void deleteCredit(long creditId);
    void approvaCredit(long creditId);
    List<Credit> getAllCredit();

    Credit getCreditById(long creditId);

}
