package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchHistoryTest {

    @Mock
    SearchHistory searchHistory;
    SearchHistory searchHistory1;

    public long id = 4444;
    public long movie_id = 5555;
    public String movie_title = "TestTitle";
    public long genre_id = 69;
    public String username = "TestUser";

    @Test
    public void searchHistoryConstructor_andSearchHistoryGetTest_happyPath()
    {
        searchHistory = new SearchHistory(id, movie_id, movie_title, genre_id, username);

        assertEquals(searchHistory.getId(), id);
        assertEquals(searchHistory.getMovie_id(), movie_id);
        assertEquals(searchHistory.getMovie_title(), movie_title);
        assertEquals(searchHistory.getGenre_id(), genre_id);
        assertEquals(searchHistory.getUsername(), username);
    }

    @Test
    public void searchHistorySetIDTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        searchHistory = new SearchHistory();
        searchHistory.setId(id);

        final Field field = searchHistory.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(searchHistory), id);
    }

    @Test
    public void searchHistorySetMovie_IDTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        searchHistory = new SearchHistory();
        searchHistory.setMovie_id(movie_id);

        final Field field = searchHistory.getClass().getDeclaredField("movie_id");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(searchHistory), movie_id);
    }

    @Test
    public void searchHistorySetMovie_titleTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        searchHistory = new SearchHistory();
        searchHistory.setMovie_title(movie_title);

        final Field field = searchHistory.getClass().getDeclaredField("movie_title");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(searchHistory), movie_title);
    }

    @Test
    public void searchHistorySetGenre_IDTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        searchHistory = new SearchHistory();
        searchHistory.setGenre_id(genre_id);

        final Field field = searchHistory.getClass().getDeclaredField("genre_id");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(searchHistory), genre_id);
    }

    @Test
    public void searchHistorySetUsernameTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        searchHistory = new SearchHistory();
        searchHistory.setUser_id(username);

        final Field field = searchHistory.getClass().getDeclaredField("username");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(searchHistory), username);
    }

    @Test
    public void searchHistoryToStringTest_happyPath()
    {
        searchHistory = new SearchHistory(id, movie_id, movie_title, genre_id, username);

        assertEquals(searchHistory.toString(), "SearchHistory{" +
                "id=" + id +
                ", movie_id=" + movie_id +
                ", movie_title='" + movie_title + '\'' +
                ", genre_id=" + genre_id +
                ", username=" + username +
                '}');
    }

    @Test
    public void searchHistoryEquals_and_hashCodeTest_happyPath()
    {
        searchHistory = new SearchHistory(id, movie_id, movie_title, genre_id, username);
        searchHistory1 = new SearchHistory(id, movie_id, movie_title, genre_id, username);

        assertTrue(searchHistory.equals(searchHistory1));
        assertEquals(searchHistory.hashCode(), searchHistory1.hashCode());
    }

    @Test
    public void searchHistoryEquals_and_hashCodeTest_notEquals_happyPath()
    {
        searchHistory = new SearchHistory(id, movie_id, movie_title, genre_id, username);
        searchHistory1 = new SearchHistory(id + 1, movie_id, movie_title, genre_id, username);

        assertFalse(searchHistory.equals(searchHistory1));
        assertNotEquals(searchHistory.hashCode(), searchHistory1.hashCode());
    }
}
