package finalProject.repositories;

import finalProject.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByItemId(int itemId);

    List<Review> findByCustomerId(int customer);
    
}
