package finalProject.repositories;

import finalProject.domain.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderlineRepository extends JpaRepository<OrderLine, Integer> {
}
