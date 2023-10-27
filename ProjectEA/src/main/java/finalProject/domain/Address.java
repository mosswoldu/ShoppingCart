package finalProject.domain;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue
    private int id;
    private String stateAddress;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    private boolean isDefault;
    @ManyToOne(fetch = FetchType.LAZY)
    private AddressType addressType;


    public Address(String stateAddress, String country, String state, String city, String zipCode, boolean isDefault, AddressType addressType) {
        this.stateAddress = stateAddress;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
        this.isDefault = isDefault;
        this.addressType = addressType;
    }
}
