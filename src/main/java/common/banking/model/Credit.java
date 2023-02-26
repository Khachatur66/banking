package common.banking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import common.banking.enums.CurrencyStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    private String creditNumber;

    private String passportNumber;

    private long takenAmount;

    private CurrencyStatus currency;

    @ManyToOne
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public long getTakenAmount() {
        return takenAmount;
    }

    public void setTakenAmount(long takenAmount) {
        this.takenAmount = takenAmount;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CurrencyStatus getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyStatus currency) {
        this.currency = currency;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return id == credit.id && takenAmount == credit.takenAmount && Objects.equals(creditNumber, credit.creditNumber) && Objects.equals(passportNumber, credit.passportNumber) && currency == credit.currency && Objects.equals(bank, credit.bank) && Objects.equals(customer, credit.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creditNumber, passportNumber, takenAmount, currency, bank, customer);
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", creditNumber='" + creditNumber + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", takenAmount=" + takenAmount +
                ", currency=" + currency +
                ", bank=" + bank +
                ", customer=" + customer +
                '}';
    }
}
