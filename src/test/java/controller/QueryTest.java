package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryTest {

    @Mock
    Query query;
    Query query1;

    public long id = 23456;
    public String username = "TestUser";
    public String queryTitle = "TestQuery";
    public String queryText = "TestText";
    public Date queryDate = new Date(System.currentTimeMillis());
    public String responseText = "TestResponse";

    @Test
    public void queryConstructor_queryGetTest_happyPath()
    {
        query = new Query(id, username, queryTitle, queryText, queryDate, responseText);

        assertTrue(query.getId() == id);
        assertTrue(query.getUsername() == username);
        assertTrue(query.getQueryTitle() == queryTitle);
        assertTrue(query.getQueryText() == queryText);
        assertTrue(query.getQueryDate() == queryDate);
        assertTrue(query.getResponseText() == responseText);
    }

    @Test
    public void setQueryIDTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        query = new Query();

        query.setId(id);

        final Field field = query.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(query), id);
    }

    @Test
    public void setQueryUsernameTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        query = new Query();

        query.setUsername(username);

        final Field field = query.getClass().getDeclaredField("username");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(query), username);
    }

    @Test
    public void setQueryTitleTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        query = new Query();

        query.setQueryTitle(queryTitle);

        final Field field = query.getClass().getDeclaredField("queryTitle");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(query), queryTitle);
    }

    @Test
    public void setQueryTextTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        query = new Query();

        query.setQueryText(queryText);

        final Field field = query.getClass().getDeclaredField("queryText");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(query), queryText);
    }

    @Test
    public void setQueryDateTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        query = new Query();

        query.setQueryDate(queryDate);

        final Field field = query.getClass().getDeclaredField("queryDate");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(query), queryDate);
    }

    @Test
    public void setQueryResponseTextTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        query = new Query();

        query.setResponseText(responseText);

        final Field field = query.getClass().getDeclaredField("responseText");
        field.setAccessible(true);
        assertEquals("fields didn't match", field.get(query), responseText);
    }

    @Test
    public void queryToStringTest_happyPath()
    {
        query = new Query(id, username, queryTitle, queryText, queryDate, responseText);

        assertEquals(query.toString(), "Query{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", queryTitle='" + queryTitle + '\'' +
                ", queryText='" + queryText + '\'' +
                ", queryDate=" + queryDate +
                ", responseText='" + responseText + '\'' +
                '}');
    }

    @Test
    public void queryEquals_and_hashCodeTest_happyPath()
    {
        query = new Query(id, username, queryTitle, queryText, queryDate, responseText);
        query1 = new Query(id, username, queryTitle, queryText, queryDate, responseText);

        assertTrue(query.equals(query1));
        assertEquals(query.hashCode(), query1.hashCode());
    }

    @Test
    public void queryEquals_and_hashCodeTest_NotEqual()
    {
        query = new Query(id, username, queryTitle, queryText, queryDate, responseText);
        query1 = new Query(id + 1, username, queryTitle, queryText, queryDate, responseText);

        assertFalse(query.equals(query1));
        assertNotEquals(query.hashCode(), query1.hashCode());
    }
}
