package client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

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
