package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewTest {

    @Mock
    Review review;
    Review review1;

    public long id = 5678;
    public long movie_id = 4321;
    public String movie_name = "TestMovie";
    public String username = "TestUser";
    public String reviewText = "TestText";
    public Date reviewDate = new Date(System.currentTimeMillis());

    @Test
    public void reviewConstructor_reviewGetTest_happyPath()
    {
        review = new Review(movie_id, movie_name, username, reviewText, reviewDate);
        review.setId(1111);

        assertTrue(review.getMovie_id() == movie_id);
        assertTrue(review.getMovie_name() == movie_name);
        assertTrue(review.getUsername() == username);
        assertTrue(review.getReviewText() == reviewText);
        assertTrue(review.getReviewDate() == reviewDate);
        assertTrue(review.getId() == 1111);
    }

    @Test
    public void reviewSetIDTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        review = new Review();

        review.setId(id);

        final Field field = review.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(review), id);
    }

    @Test
    public void reviewSetMovieIDTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        review = new Review();

        review.setMovie_id(movie_id);

        final Field field = review.getClass().getDeclaredField("movie_id");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(review), movie_id);
    }

    @Test
    public void reviewSetMovieNameTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        review = new Review();

        review.setMovie_name(movie_name);

        final Field field = review.getClass().getDeclaredField("movie_name");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(review), movie_name);
    }

    @Test
    public void reviewSetUsernameTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        review = new Review();

        review.setUsername(username);

        final Field field = review.getClass().getDeclaredField("username");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(review), username);
    }

    @Test
    public void reviewSetReviewTextTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        review = new Review();

        review.setReviewText(reviewText);

        final Field field = review.getClass().getDeclaredField("reviewText");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(review), reviewText);
    }

    @Test
    public void reviewSetReviewDateTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        review = new Review();

        review.setReviewDate(reviewDate);

        final Field field = review.getClass().getDeclaredField("reviewDate");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(review), reviewDate);
    }

    @Test
    public void reviewToStringTest_happyPath()
    {
        review = new Review(movie_id, movie_name, username, reviewText, reviewDate);
        review.setId(id);

        assertEquals(review.toString(), "Review{" +
                "id=" + id +
                ", movie_id=" + movie_id +
                ", movie_name='" + movie_name + '\'' +
                ", username='" + username + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", reviewDate=" + reviewDate +
                '}');
    }

    @Test
    public void reviewEquals_and_hashCodeTest_happyPath()
    {
        review = new Review(movie_id, movie_name, username, reviewText, reviewDate);
        review1 = new Review(movie_id, movie_name, username, reviewText, reviewDate);

        assertTrue(review.equals(review1));
        assertEquals(review.hashCode(), review1.hashCode());
    }

    @Test
    public void reviewEquals_and_hashCodeTest_NotEqual()
    {
        review = new Review(movie_id, movie_name, username, reviewText, reviewDate);
        review1 = new Review(movie_id + 1, movie_name, username, reviewText, reviewDate);

        assertFalse(review.equals(review1));
        assertNotEquals(review.hashCode(), review1.hashCode());
    }
}
