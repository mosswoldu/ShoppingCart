package finalProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Status")
public class Status {
    @Id
    @GeneratedValue
    private int id;
    private String status;

    public Status(String status) {
        this.status = status;
    }
}
