package client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

import java.util.List;

@Data
public class CustomersDTO {

    private List<CustomerDTO> customerDTOList;

    @JsonCreator
    public CustomersDTO(List<CustomerDTO> customerDTOList) {
        this.customerDTOList = customerDTOList;
    }
}
