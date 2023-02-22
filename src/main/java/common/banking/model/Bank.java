package common.banking.model;

import javax.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    long bankMoney;

    int customersAmount;

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

    public long getBankMoney() {
        return bankMoney;
    }

    public void setBankMoney(long bankMoney) {
        this.bankMoney = bankMoney;
    }

    public int getCustomersAmount() {
        return customersAmount;
    }

    public void setCustomersAmount(int amountCustomers) {
        this.customersAmount = amountCustomers;
    }
}
