package common.banking.controller;

import common.banking.exception.NotFoundException;
import common.banking.model.Bank;
import common.banking.service.interfaces.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") int id) throws NotFoundException {
        return ResponseEntity.ok(bankService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Bank>> getAll() {
        return ResponseEntity.ok(bankService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody Bank bank) {
        bankService.save(bank);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Bank bank) {
        bankService.update(bank);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id) {
        bankService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
