package finalProject.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrdersDTO {
    private List<OrderDTO> orderDTOList = new ArrayList<>();

    public void setOrderDTOList(List<OrderDTO> orderDTOList) {
        this.orderDTOList = orderDTOList;
    }
}
