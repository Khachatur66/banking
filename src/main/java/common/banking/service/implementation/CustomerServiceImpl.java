package common.banking.service.implementation;

import common.banking.dto.request.CustomerRequest;
import common.banking.exception.NotFoundException;
import common.banking.model.Credit;
import common.banking.model.Customer;
import common.banking.repository.CreditRepository;
import common.banking.repository.CustomerRepository;
import common.banking.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CreditRepository creditRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, CreditRepository creditRepository) {
        this.customerRepository = customerRepository;
        this.creditRepository = creditRepository;
    }

    @Override
    public Customer getById(int id) throws NotFoundException {
        return customerRepository.getById(id).orElseThrow(() -> new NotFoundException("Could not find Customer with current id: " + id));
    }

    @Override
    public Long getCustomerBalanceById(int id) throws NotFoundException {
        return customerRepository.findCustomerBalanceById(id).orElseThrow(() -> new NotFoundException("Could not find Customer with current id: " + id));
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
       /*Customer customer1 = customerRepository.getByPassportNumber(customer.getPassportNumber());

       if (customer1.isHasCredit()) {
         int creditAmount = customerRepository.countCustomerByPassportNumber(customer1.getPassportNumber());
       }*/
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(CustomerRequest request) throws NotFoundException {
        /*Customer customer = customerRepository.findByPassportNumber(request.getPassportNumber());
        CustomerRequest customerRequest = customerRepository.getByPassportNumber(request.getPassportNumber());

        if (customerRequest != null) {
            customerRequest.setHasCredit(request.isHasCredit());
        }else {
            throw new NotFoundException("Illegal argument");
        }*/
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }
}
