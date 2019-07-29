package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="mvdb1.database.windows.net", allowedHeaders="*", methods = { GET, POST, PUT, DELETE, OPTIONS})
public class ReviewController {

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping("/reviews")
    public List<Review> getReviews(){
        return reviewRepository.findAll();
    }

    @GetMapping("/review/{id}")
    public Optional<Review> getReview(@PathVariable Long id){
        return reviewRepository.findById(id);
    }

    @DeleteMapping("/review/{id}")
    public boolean deleteReview(@PathVariable Long id){
        reviewRepository.deleteById(id);
        return true;
    }

    @PutMapping("/review/update")
    public Review updateReview(@RequestBody Review review){
        return reviewRepository.save(review);
    }

    @PostMapping("/review/create")
    public Review createReview(@RequestBody Review review){
        return reviewRepository.save(review);
    }
}
