package finalProject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private double price;
    private String image;//TODO
    private String barcodeNumber;
    private int quantityStock;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private List<Review> reviewList;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Item> itemList = new ArrayList<Item>();


}
