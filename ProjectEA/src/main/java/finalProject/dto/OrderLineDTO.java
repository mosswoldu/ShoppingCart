package finalProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import finalProject.domain.Item;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderLineDTO {
    private int id;
    private int quantity;
    @JsonProperty("discount")
    private boolean discount;
    private double discountValue;
    private ItemDTO item;
}
