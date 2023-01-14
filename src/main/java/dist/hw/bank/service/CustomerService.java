package dist.hw.bank.service;

import java.time.LocalDateTime;
import java.util.List;

import dist.hw.bank.logging.ILogRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dist.hw.bank.Repository.ICustomerRepository;
import dist.hw.bank.model.Customer;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private ICustomerRepository<Customer> customerRepository;

	@Autowired
	private ILogRepository logRepository;


	private PasswordEncoder passwordEncoder;
	public CustomerService(){
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public List<Customer> getAll() {

		try {

			return customerRepository.findAll();
		}
		catch(Exception e) {
			return null;
		}

	}

	@Override
	public Customer saveCustomer(Customer customer) {

		customer.getAccount().setCreateTime(LocalDateTime.now());
		String encodedPassword = this.passwordEncoder.encode(customer.getPassword());
		customer.setPassword(encodedPassword);
		return customerRepository.save(customer);
	}



	public Customer getCustomerByid(long id) {
		return customerRepository.findById(id).
				orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
	}



	@Override
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public void updatePassword(Customer customer, String password) {

	}

}
