package finalProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import finalProject.domain.AddressType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
