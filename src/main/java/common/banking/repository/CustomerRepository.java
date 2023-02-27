package common.banking.repository;

import common.banking.dto.request.CustomerRequest;
import common.banking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.id = ?1")
    Optional<Customer> getById(int id);

    @Query("SELECT c.money_AMD FROM Customer c WHERE c.id = ?1")
    Optional<Long> findCustomerBalanceById(int id);

        @Query("SELECT new common.banking.dto.request.CustomerRequest(cs.passportNumber, cs.hasCredit, cs.creditAmount) FROM Customer cs LEFT JOIN Credit cd " +
                "ON cs.passportNumber = cd.passportNumber WHERE cs.passportNumber = ?1")
    CustomerRequest getByPassportNumber(String passportNumber);

    @Query("SELECT COUNT(DISTINCT c.passportNumber) FROM Customer c WHERE c.passportNumber = ?1")
    int countCustomerByPassportNumber(String passportNumber);

    @Query("SELECT c FROM Customer c WHERE c.passportNumber = ?1")
    Customer findByPassportNumber(String passportNumber);
}
