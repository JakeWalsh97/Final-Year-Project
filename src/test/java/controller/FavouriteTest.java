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
public class FavouriteTest {

    @Mock
    Favourite favourite;
    Favourite favourite1;

    public long id = 34567;
    public String username = "TestUser";
    public long movie_id = 9999;
    public String title = "TestTitle";
    public String poster_path = "TestPosterPath";
    public Date release_date = new Date(System.currentTimeMillis());

    @Test
    public void favouriteConstructor_favouriteGetTest_happyPath()
    {
        favourite = new Favourite(id, username, movie_id, title, poster_path, release_date);

        assertTrue(favourite.getId() == id);
        assertTrue(favourite.getUsername() == username);
        assertTrue(favourite.getMovie_id() == movie_id);
        assertTrue(favourite.getTitle() == title);
        assertTrue(favourite.getPoster_path() == poster_path);
        assertTrue(favourite.getRelease_date() == release_date);
    }

    @Test
    public void favouriteSetIDTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        favourite = new Favourite();

        favourite.setId(id);

        final Field field = favourite.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(favourite), id);
    }

    @Test
    public void favouriteSetUsernameTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        favourite = new Favourite();

        favourite.setUsername(username);

        final Field field = favourite.getClass().getDeclaredField("username");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(favourite), username);
    }

    @Test
    public void favouriteSetMovieIDTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        favourite = new Favourite();

        favourite.setMovie_id(movie_id);

        final Field field = favourite.getClass().getDeclaredField("movie_id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(favourite), movie_id);
    }

    @Test
    public void favouriteSetTitleTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        favourite = new Favourite();

        favourite.setTitle(title);

        final Field field = favourite.getClass().getDeclaredField("title");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(favourite), title);
    }

    @Test
    public void favouriteSetPosterPathTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        favourite = new Favourite();

        favourite.setPoster_path(poster_path);

        final Field field = favourite.getClass().getDeclaredField("poster_path");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(favourite), poster_path);
    }

    @Test
    public void favouriteSetReleaseDateTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        favourite = new Favourite();

        favourite.setRelease_date(release_date);

        final Field field = favourite.getClass().getDeclaredField("release_date");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(favourite), release_date);
    }

    @Test
    public void favouriteToStringTest_happyPath()
    {
        favourite = new Favourite(id, username, movie_id, title, poster_path, null);

        System.out.println(favourite.toString());

        assertEquals(favourite.toString(), "Favourite{id=34567, username='TestUser', movie_id=9999, title='TestTitle', poster_path='TestPosterPath', release_date=null}");
    }

    @Test
    public void favouriteEquals_and_hashCodeTest_happyPath()
    {
        favourite = new Favourite(id, username, movie_id, title, poster_path, null);
        favourite1 = new Favourite(id, username, movie_id, title, poster_path, null);

        assertTrue(favourite.equals(favourite1));
        assertEquals(favourite.hashCode(), favourite1.hashCode());
    }

    @Test
    public void favouriteEquals_and_hashCodeTest_notEqual_expectedError() throws AssertionError
    {
        favourite = new Favourite(id, username, movie_id, title, poster_path, null);
        favourite1 = new Favourite(id, username, movie_id, title, poster_path, new Date(System.currentTimeMillis()));

        assertNotEquals(favourite.hashCode(), favourite1.hashCode());

        try {
            assertTrue(favourite.equals(favourite1));
        }
        catch (AssertionError e)
        {
            System.out.println(e.getMessage());
        }
    }
}
