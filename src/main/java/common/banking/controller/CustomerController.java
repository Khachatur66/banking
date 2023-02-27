package common.banking.controller;

import common.banking.dto.request.CustomerRequest;
import common.banking.exception.NotFoundException;
import common.banking.model.Customer;
import common.banking.service.interfaces.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    public final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") int id) throws NotFoundException {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @GetMapping("/balance/{id}")
    public ResponseEntity<?> getBalanceById(@PathVariable(value = "id") int id) throws NotFoundException {
        return ResponseEntity.ok(customerService.getCustomerBalanceById(id));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody Customer customer) {
        customerService.save(customer);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Customer customer) {
        customerService.update(customer);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/dto")
    public ResponseEntity<Void> updateCustomer(@RequestBody CustomerRequest customerRequest) throws NotFoundException {
        customerService.updateCustomer(customerRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id) {
        customerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
