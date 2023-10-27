package client.dto;


import java.util.ArrayList;
import java.util.List;

public class OrdersDTO {
    private List<OrderDTO> orderDTOList = new ArrayList<>();

    public void setOrderDTOList(List<OrderDTO> orderDTOList) {
        this.orderDTOList = orderDTOList;
    }
}
