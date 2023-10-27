package finalProject.domain;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Corporate extends Customer {
    private String name;
}
