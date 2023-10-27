package finalProject.dto;

import finalProject.domain.Customer;
import finalProject.domain.Item;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewDTO {
    private int id;

    private String title;
    private String description;
    private int numberStar;
    private LocalDate date = LocalDate.now();
    private Item item;
    private Customer customer;
}
