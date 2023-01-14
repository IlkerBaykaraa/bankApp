package dist.hw.bank.controller;


import dist.hw.bank.logging.ILogRepository;
import dist.hw.bank.logging.ILogService;
import dist.hw.bank.model.Credit;
import dist.hw.bank.model.Customer;
import dist.hw.bank.service.IAccountService;
import dist.hw.bank.service.ICreditService;
import dist.hw.bank.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ICreditService creditService;

    @Autowired
    private ILogService logService;

    @GetMapping("{userId}")
    public ResponseEntity<?> getAccountInfo(@PathVariable long userId){
        return ResponseEntity.ok(accountService.getById(userId));
    }

    @GetMapping("log/{userId}")
    public ResponseEntity<?> getLogs(@PathVariable long userId){
        return ResponseEntity.ok(logService.getAllLogsById(userId));
    }

    @PostMapping()
    public ResponseEntity<?> approveCredit(@RequestBody Credit credit){
        creditService.saveCredit(credit);
        return ResponseEntity.ok(HttpStatus.OK);
    }










}
