package finalProject.domain;

import finalProject.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customerId")
    private int id;
    private String emailAddress;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private List<CreditCard> creditCardList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private List<Address> addressList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private List<Order> orderList = new ArrayList<>();

    public List<CreditCard> getCreditCardList() {
        return creditCardList;
    }

    public void setCreditCardList(CreditCard creditCardList) {
        this.creditCardList.add(creditCardList);
    }

    public List<Address> getAddressList() {
        return addressList;
    }


    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList.addAll(orderList);
    }

    public Customer(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
