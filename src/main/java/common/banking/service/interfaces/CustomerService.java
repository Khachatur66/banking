package common.banking.service.interfaces;

import common.banking.dto.request.CustomerRequest;
import common.banking.exception.NotFoundException;
import common.banking.model.Customer;

public interface CustomerService extends AbstractService<Customer>{
    Customer getById(int id) throws NotFoundException;

    Long getCustomerBalanceById(int id) throws NotFoundException;

    void updateCustomer(CustomerRequest request);

}
