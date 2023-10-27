package client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDTO {
    private int id;
    private String typeCustomer;
    private String emailAddress;
    private List<CreditCardDTO> creditCard = new ArrayList<>();
    private List<AddressDTO> address = new ArrayList<>();
    private List<OrderDTO> order = new ArrayList<>();
}
