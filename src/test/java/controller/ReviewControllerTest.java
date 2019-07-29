package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import repository.ReviewRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewControllerTest {

    /**
     * Mocking both the ReviewController and ReviewRepository to simulate the real database functionality.
     */
    @Mock
    ReviewController reviewController;

    @Mock
    ReviewRepository reviewRepository;

    /**
     * Using a setUp method to initialize the reviewController to avoid repeating code.
     */
    @Before
    public void setUp()
    {
        reviewController = new ReviewController(reviewRepository);
    }

    /**
     * Calling getReviews method and returning all reviews from the database.
     */
    @Test
    public void getReviewsTest_happyPath()
    {
        List<Review> response = reviewController.getReviews();

        System.out.println(response.toString());
    }

    /**
     * Calling getReview method and returning a specific review from database using ID.
     */
    @Test
    public void getReviewTest_happyPath()
    {
        long id = 1;
        Optional<Review> response = reviewController.getReview(id);

        System.out.println(response.toString());
    }

    /**
     * Calling createReview and deleteReview methods to test the add and delete functionality of the database.
     */
    @Test
    public void createReview_and_deleteReviewTest_happyPath()
    {
        Review review = new Review(11100, "Test", "Test", "Test", new Date(System.currentTimeMillis()));
        reviewController.createReview(review);
        reviewRepository.save(review);

        reviewController.deleteReview(review.id);
        System.out.println("Review deleted from database!");
    }
}
