package common.banking.repository;

import common.banking.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
    @Query("SELECT b FROM Bank b WHERE b.id = ?1")
    Optional<Bank> getById(int id);
}
