package finalProject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "OrderTable")
public class Order {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Status status;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<OrderLine> orderLineList;

}
