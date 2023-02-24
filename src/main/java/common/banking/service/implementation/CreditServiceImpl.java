package common.banking.service.implementation;

import common.banking.exception.NotFoundException;
import common.banking.model.Credit;
import common.banking.repository.CreditRepository;
import common.banking.service.interfaces.CreditService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;

    public CreditServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public Credit getById(int id) throws NotFoundException {
        return creditRepository.getById(id).orElseThrow(() -> new NotFoundException("Could not find Credit with current id: " + id));
    }

    @Override
    public List<Credit> getAll() {
        return creditRepository.findAll();
    }

    @Override
    public void save(Credit credit) {
        creditRepository.save(credit);
    }

    @Override
    public void update(Credit credit) {
        creditRepository.save(credit);
    }

    @Override
    public void deleteById(int id) {
        creditRepository.deleteById(id);
    }
}
