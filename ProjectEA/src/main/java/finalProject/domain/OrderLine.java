package finalProject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "OrderLine")
public class OrderLine {
    @Id
    @GeneratedValue
    private int id;
    private int quantity;
    private boolean discount;
    private double discountValue;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Item item;

    public OrderLine(int quantity, boolean discount, double discountValue) {
        this.quantity = quantity;
        this.discount = discount;
        this.discountValue = discountValue;
    }
}
