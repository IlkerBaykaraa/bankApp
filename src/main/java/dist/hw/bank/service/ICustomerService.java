package dist.hw.bank.service;

import java.util.List;

import dist.hw.bank.model.Customer;

public interface ICustomerService {

	List<Customer> getAll();
	Customer saveCustomer(Customer customer);
	Customer getCustomerByid(long id);



	void deleteCustomer(long id);

	void updatePassword(Customer customer,String password);


}
