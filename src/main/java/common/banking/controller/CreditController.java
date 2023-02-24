package common.banking.controller;

import common.banking.exception.NotFoundException;
import common.banking.model.Credit;
import common.banking.service.implementation.CreditServiceImpl;
import common.banking.service.interfaces.CreditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit")
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Credit> getById(@PathVariable(value = "id") int id) throws NotFoundException {
        return ResponseEntity.ok(creditService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Credit>> getAll() {
        return ResponseEntity.ok(creditService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody Credit credit) {
        creditService.save(credit);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Credit credit) {
        creditService.update(credit);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id) {
        creditService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
