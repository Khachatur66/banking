package common.banking.service.interfaces;

import common.banking.exception.NotFoundException;
import common.banking.model.Bank;

public interface BankService extends AbstractService<Bank>{

    Bank getById(int id) throws NotFoundException;
}
