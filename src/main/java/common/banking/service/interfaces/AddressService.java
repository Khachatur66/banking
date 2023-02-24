package common.banking.service.interfaces;

import common.banking.exception.NotFoundException;
import common.banking.model.Address;
import common.banking.model.Bank;

import java.util.List;

public interface AddressService extends AbstractService<Address> {

    Address getById(int id) throws NotFoundException;
}
