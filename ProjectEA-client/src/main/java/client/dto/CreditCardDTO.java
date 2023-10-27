package client.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditCardDTO {
    private int id;
    private int cardNumber;
    private String expirationDate;
    private String securityCode;
}
