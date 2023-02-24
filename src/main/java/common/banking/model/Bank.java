package common.banking.model;

import common.banking.enums.CurrencyStatus;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private long bankMoney_AMD;

    private long bankMoney_USD;

    private long bankMoney_EUR;

   private int customersAmount;

   @OneToMany(mappedBy = "bank")
   private List<Credit> credit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBankMoney_AMD() {
        return bankMoney_AMD;
    }

    public void setBankMoney_AMD(long bankMoney_AMD) {
        this.bankMoney_AMD = bankMoney_AMD;
    }

    public long getBankMoney_USD() {
        return bankMoney_USD;
    }

    public void setBankMoney_USD(long bankMoney_USD) {
        this.bankMoney_USD = bankMoney_USD;
    }

    public long getBankMoney_EUR() {
        return bankMoney_EUR;
    }

    public void setBankMoney_EUR(long bankMoney_EUR) {
        this.bankMoney_EUR = bankMoney_EUR;
    }

    public List<Credit> getCredit() {
        return credit;
    }

    public void setCredit(List<Credit> credit) {
        this.credit = credit;
    }

    public int getCustomersAmount() {
        return customersAmount;
    }

    public void setCustomersAmount(int amountCustomers) {
        this.customersAmount = amountCustomers;
    }
}
