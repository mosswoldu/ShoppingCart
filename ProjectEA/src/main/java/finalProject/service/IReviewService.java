package finalProject.service;

import finalProject.domain.Review;
import finalProject.dto.ReviewDTO;

import java.util.List;

public interface IReviewService {
    Review addReview(Review review, int customerId, int itemId);

    List<Review> getReviewsByItem(int itemId);

    List<Review> getReviewsByCustomerId(int customerId);

    Review getReviewById(int reviewId);
    Review updateReviewById(int reviewId, ReviewDTO reviewDTO);
    void deleteReviewById(int id);

}
