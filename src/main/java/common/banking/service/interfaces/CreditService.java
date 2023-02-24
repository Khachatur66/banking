package common.banking.service.interfaces;

import common.banking.exception.NotFoundException;
import common.banking.model.Credit;

import java.util.Optional;

public interface CreditService extends AbstractService<Credit> {

    Credit getById(int id) throws NotFoundException;
}
