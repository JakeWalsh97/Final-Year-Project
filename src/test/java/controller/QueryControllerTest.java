package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import repository.QueryRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryControllerTest {

    /**
     * Mocking both the QueryController and QueryRepository to simulate the real database functionality.
     */
    @Mock
    QueryController queryController;

    @Mock
    QueryRepository queryRepository;

    /**
     * Using a setUp method to initialize the queryController to avoid repeating code.
     */
    @Before
    public void setUp()
    {
        queryController = new QueryController(queryRepository);
    }

    /**
     * Calling getQueries method and returning all queries from the database.
     */
    @Test
    public void getQueriesTest_happyPath()
    {
        List<Query> response = queryController.getQueries();

        System.out.println(response.toString());
    }

    /**
     * Calling getQuery method and returning a specific query from database using ID.
     */
    @Test
    public void getQueryTest_happyPath()
    {
        long id = 1;
        Optional<Query> response = queryController.getQuery(id);

        System.out.println(response.toString());
    }

    /**
     * Calling createQuery and deleteQuery methods to test the add and delete functionality of the database.
     */
    @Test
    public void createQuery_and_deleteQueryTest_happyPath()
    {
        Query query = new Query(1111, "Test", "Test", "Test", new Date(System.currentTimeMillis()), "");
        queryController.createQuery(query);
        queryRepository.save(query);

        queryController.deleteQuery(query.id);
        System.out.println("Query deleted from database!");
    }

    /**
     * Calling addQuery method to test the default add query functionality passing absolute values.
     */
    @Test
    public void addQueryTest()
    {
        String response = queryController.addQuery();
        assertTrue(response == "Query Successfully saved to the database");
    }
}
