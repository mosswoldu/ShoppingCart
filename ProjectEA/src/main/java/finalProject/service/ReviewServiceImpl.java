package finalProject.service;

import finalProject.domain.Customer;
import finalProject.domain.Item;
import finalProject.domain.Review;
import finalProject.dto.ReviewDTO;
import finalProject.repositories.CustomerRepository;
import finalProject.repositories.ItemRepository;
import finalProject.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements IReviewService{
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review addReview(Review review, int itemId, int customerId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new EntityNotFoundException("Item not found"));
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        review.setItem(item);
        review.setCustomer(customer);
        List<Review> reviewList = item.getReviewList();

        reviewList.add(review);
        item.setReviewList(reviewList);
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByItem(int itemId) {
        return reviewRepository.findByItemId(itemId);
    }

    @Override
    public List<Review> getReviewsByCustomerId(int customerId) {
        return reviewRepository.findByCustomerId(customerId);
    }

    @Override
    public Review getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));
    }
    @Override
    public Review updateReviewById(int reviewId, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));
        if (reviewDTO.getTitle() != null) {
            review.setTitle(reviewDTO.getTitle());
        }
        if (reviewDTO.getNumberStar() != 0) {
            review.setNumberStar(reviewDTO.getNumberStar());
        }
        if (reviewDTO.getDescription() != null) {
            review.setDescription(reviewDTO.getDescription());
        }
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReviewById(int id) {
        reviewRepository.deleteById(id);
    }
}
