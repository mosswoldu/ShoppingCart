package client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddressDTO {
    private int id;
    private String stateAddress;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    @JsonProperty("isDefault")
    private boolean isDefault;
    private AddressTypeDTO addressType;
}
