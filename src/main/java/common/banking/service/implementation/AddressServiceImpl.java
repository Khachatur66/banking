package common.banking.service.implementation;

import common.banking.exception.NotFoundException;
import common.banking.model.Address;
import common.banking.repository.AddressRepository;
import common.banking.service.interfaces.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getById(int id) throws NotFoundException {
        return addressRepository
                .getByAddressId(id)
                .orElseThrow(() -> new NotFoundException("Could not find address with current id: " + id));
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Transactional
    @Override
    public void save(Address address)  {
        addressRepository.save(address);
    }

    @Transactional
    @Override
    public void update(Address address) {
        addressRepository.save(address);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        addressRepository.deleteById(id);
    }
}
