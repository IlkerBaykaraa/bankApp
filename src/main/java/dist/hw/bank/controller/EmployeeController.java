package dist.hw.bank.controller;

import dist.hw.bank.model.Customer;
import dist.hw.bank.service.CustomerService;
import dist.hw.bank.service.IAccountService;
import dist.hw.bank.service.ICreditService;
import dist.hw.bank.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ICreditService creditService;

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getAccountInfo(@PathVariable long userId){
        return ResponseEntity.ok(customerService.getCustomerByid(userId));
    }

    @GetMapping({"/credit"})
    public ResponseEntity<?> getAllCredit(){
        return ResponseEntity.ok(creditService.getAllCredit());
    }

    @PostMapping("/credit/{creditId}")
    public ResponseEntity<?> approveCredit(@PathVariable long creditId){
        creditService.approvaCredit(creditId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping({"/creditbyid/{creditId}"})
    public ResponseEntity<?> getAllCredit(@PathVariable long creditId){
        return ResponseEntity.ok(creditService.getCreditById(creditId));
    }

    @GetMapping({"/customer/{identity}"})
    public ResponseEntity<?> getCustomerByIdentity(@PathVariable long identity){
        return ResponseEntity.ok(customerService.getCustomerByid(identity));
    }
}