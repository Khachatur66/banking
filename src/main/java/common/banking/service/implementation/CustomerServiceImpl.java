package common.banking.service.implementation;

import common.banking.exception.NotFoundException;
import common.banking.model.Customer;
import common.banking.repository.CustomerRepository;
import common.banking.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }
}
