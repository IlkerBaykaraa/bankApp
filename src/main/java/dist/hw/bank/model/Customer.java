package dist.hw.bank.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="customers")
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name",nullable = false)
	private String name;

	@Column(name = "surname",nullable = false)
	private String surname;

	@Column(name = "identityNo",nullable = true)
	private String identityNo;

	@Column(name = "password",nullable = true)
	private String password;

	@Column(name = "phoneNumber",nullable = false)
	private String phoneNumber;

	@Column(name = "email",nullable = false)
	private String email;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "accountId")
	private Account account;




	public Customer() {

	}





	
	
	
	

}
