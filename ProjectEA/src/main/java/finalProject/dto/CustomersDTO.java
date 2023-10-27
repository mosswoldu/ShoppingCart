package finalProject.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomersDTO {
    private List<CustomerDTO> customerDTOList = new ArrayList<>();

    public void setCustomerDTOList(List<CustomerDTO> customerDTOList) {
        this.customerDTOList = customerDTOList;
    }
}
