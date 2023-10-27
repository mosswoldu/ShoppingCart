package finalProject.dto;

import finalProject.domain.Item;
import finalProject.domain.Review;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemDTO {
    private int id;
    private String name;
    private String description;
    private double price;
    private String image;//TODO
    private String barcodeNumber;
    private int quantityStock;

    private List<Review> reviewList;
    private List<Item> itemList = new ArrayList<Item>();

}
