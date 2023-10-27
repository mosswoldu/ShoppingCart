package finalProject.controller;
import finalProject.domain.Review;
import finalProject.dto.ReviewDTO;
import finalProject.service.IReviewService;
import finalProject.service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private IReviewService reviewService;

    @PostMapping("/{itemId}/{customerId}")
    public Review addReview(@PathVariable int itemId, @PathVariable int customerId, @RequestBody Review review) {
        return reviewService.addReview(review, itemId, customerId);
    }

    @GetMapping("/item/{itemId}")
    public List<Review> getReviewsByItemId(@PathVariable int itemId) {
        return reviewService.getReviewsByItem(itemId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Review> getReviewsByCustomerId(@PathVariable int customerId) {
        return reviewService.getReviewsByCustomerId(customerId);
    }

    @GetMapping("/{reviewId}")
    public Review getReviewById(@PathVariable int reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReviewById(@PathVariable int reviewId, @RequestBody ReviewDTO reviewDTO) {
        Review review = reviewService.updateReviewById(reviewId, reviewDTO);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReviewById(@PathVariable int reviewId) {
        reviewService.deleteReviewById(reviewId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
