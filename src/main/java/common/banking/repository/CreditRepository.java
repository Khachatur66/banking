package common.banking.repository;

import common.banking.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Integer> {

    @Query("SELECT c FROM Credit c WHERE c.id = ?1")
    Optional<Credit> getById(int id);

    Credit findByCreditNumber(String creditNumber);

    @Query("SELECT c FROM Credit c WHERE c.passportNumber = ?1")
    Credit findByPassportNumber(String passportNumber);
}

