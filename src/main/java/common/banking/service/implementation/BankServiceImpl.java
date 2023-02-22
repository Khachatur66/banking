package common.banking.service.implementation;

import common.banking.exception.NotFoundException;
import common.banking.model.Bank;
import common.banking.repository.BankRepository;
import common.banking.service.interfaces.BankService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank getById(int id) throws NotFoundException {
        return bankRepository
                .getById(id)
                .orElseThrow(() -> new NotFoundException("Could not find Bank with current id:" + id));
    }

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    @Override
    public void save(Bank bank) {
        bankRepository.save(bank);
    }

    @Override
    public void update(Bank bank) {
        bankRepository.save(bank);
    }

    @Override
    public void deleteById(int id) {
        bankRepository.deleteById(id);
    }
}
