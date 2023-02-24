package common.banking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import common.banking.enums.CurrencyStatus;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;

    @JsonIgnore
    private boolean hasCredit;

    @JsonIgnore
    private short creditAmount;

    @JsonIgnore
    private long money_AMD;

    @JsonIgnore
    private long money_USD;

    @JsonIgnore
    private long money_EUR;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "customer_address",
    joinColumns = @JoinColumn(name = "customer"),
    inverseJoinColumns = @JoinColumn(name = "address"))
    private List<Address> address;

    @OneToMany(mappedBy = "customer")
    private List<Credit> credit;

    public Customer() {
        this.hasCredit = false;
        this.creditAmount = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public boolean isHasCredit() {
        return hasCredit;
    }

    public void setHasCredit(boolean hasCredit) {
        this.hasCredit = hasCredit;
    }

    public short getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(short creditAmount) {
        this.creditAmount = creditAmount;
    }

    public long getMoney_AMD() {
        return money_AMD;
    }

    public void setMoney_AMD(long money_AMD) {
        this.money_AMD = money_AMD;
    }

    public long getMoney_USD() {
        return money_USD;
    }

    public void setMoney_USD(long money_USD) {
        this.money_USD = money_USD;
    }

    public long getMoney_EUR() {
        return money_EUR;
    }

    public void setMoney_EUR(long money_EUR) {
        this.money_EUR = money_EUR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && hasCredit == customer.hasCredit && creditAmount == customer.creditAmount && money_AMD == customer.money_AMD && money_USD == customer.money_USD && money_EUR == customer.money_EUR && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, hasCredit, creditAmount, money_AMD, money_USD, money_EUR, address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", hasCredit=" + hasCredit +
                ", creditAmount=" + creditAmount +
                ", money_AMD=" + money_AMD +
                ", money_USD=" + money_USD +
                ", money_EUR=" + money_EUR +
                ", address=" + address +
                '}';
    }
}
