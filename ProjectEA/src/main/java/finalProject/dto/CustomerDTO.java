package finalProject.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import finalProject.domain.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "typeCustomer",
        use = JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PersonalDTO.class, name = "personal"),
        @JsonSubTypes.Type(value = CorporateDTO.class, name = "corporate")
})
public class CustomerDTO {
    private int id;
    private String emailAddress;
    private List<CreditCardDTO> creditCard = new ArrayList<>();
    private List<AddressDTO> address = new ArrayList<>();
    private List<OrderDTO> order= new ArrayList<>();

}
