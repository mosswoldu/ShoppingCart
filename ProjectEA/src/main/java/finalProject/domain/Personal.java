package finalProject.domain;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Personal extends Customer {
    private String firstname;
    private String lastname;
}
