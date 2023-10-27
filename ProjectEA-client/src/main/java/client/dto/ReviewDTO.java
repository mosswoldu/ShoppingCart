package client.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewDTO {
    private int id;

    private String title;
    private String description;
    private int numberStar;
    private LocalDate date = LocalDate.now();
    private ItemDTO item;
    private CustomerDTO customer;
}
