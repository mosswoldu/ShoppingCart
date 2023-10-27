package client.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {
    private int id;
    private StatusDTO status;
    private List<OrderLineDTO> orderLine;
}
