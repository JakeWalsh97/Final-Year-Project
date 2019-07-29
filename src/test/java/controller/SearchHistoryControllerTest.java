package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import repository.SearchHistoryRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchHistoryControllerTest {

    /**
     * Mocking both the searchHistoryController and searchHistoryRepository to simulate the real database functionality.
     */
    @Mock
    SearchHistoryController searchHistoryController;

    @Mock
    SearchHistoryRepository searchHistoryRepository;

    /**
     * Using a setUp method to initialize the searchHistoryController to avoid repeating code.
     */
    @Before
    public void setUp()
    {
        searchHistoryController = new SearchHistoryController(searchHistoryRepository);
    }

    /**
     * Calling getSearchHistory method and returning all searchHistory from the database.
     */
    @Test
    public void getAllSearchHistoryTest_happyPath()
    {
        List<SearchHistory> response = searchHistoryController.getAllSearchHistory();
        System.out.println(response.toString());
    }

    /**
     * Calling getSearchHistory method and returning a specific searchHistory from database using ID.
     */
    @Test
    public void getSearchHistoryTest_happyPath()
    {
        long id = 1;
        Optional<SearchHistory> response = searchHistoryController.getSearchHistory(id);

        System.out.println(response.toString());
    }

    /**
     * Calling createSearchHistory and deleteSearchHistory methods to test the add and delete functionality of the database.
     */
    @Test
    public void createSearchHistory_and_deleteSearchHistoryTest_happyPath()
    {
        SearchHistory searchHistory = new SearchHistory(11111, 11111, "Test", 69, "Test");
        searchHistoryController.createSearchHistory(searchHistory);
        searchHistoryRepository.save(searchHistory);

        searchHistoryController.deleteSearchHistory(searchHistory.id);
        System.out.println("Search History deleted from database!");
    }

    /**
     * Calling addSearchHistory method to test the default add searchHistory functionality passing absolute values.
     */
    @Test
    public void addSearchHistoryTest_happyPath()
    {
        String response = searchHistoryController.addSearchHistory();

        assertTrue(response == "Search History successfully saved to the database");
    }
}
