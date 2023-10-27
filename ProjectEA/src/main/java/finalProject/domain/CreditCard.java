package finalProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "CreditCard")
public class CreditCard {
    @Id
    @GeneratedValue
    private int id;
    private int cardNumber;
    private String expirationDate;
    private String securityCode;

    public CreditCard(int cardNumber, String expirationDate, String securityCode) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }
}
