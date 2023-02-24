package common.banking.model;

import common.banking.enums.CurrencyStatus;

import javax.persistence.*;

@Entity
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
}
