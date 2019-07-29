package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    /**
     * Mocking both the UserController and UserRepository to simulate the real database functionality.
     */
    @Mock
    UserController userController;

    @Mock
    UserRepository userRepository;

    /**
     * Using a setUp method to initialize the userController to avoid repeating code.
     */
    @Before
    public void setUp()
    {
        userController = new UserController(userRepository);
    }

    /**
     * Calling getUsers method and returning all users from the database.
     */
    @Test
    public void getUsersTest_happyPath() {
        List<User> response = userController.getUsers();

        System.out.println(response.toString());
    }

    /**
     * Calling getUser method and returning a specific user from database using ID.
     */
    @Test
    public void getUserTest_happyPath()
    {
        long id = 1;
        Optional<User> response = userController.getUser(id);

        System.out.println(response.toString());
    }

    /**
     * Calling createUser and deleteUser methods to test the add and delete functionality of the database.
     */
    @Test
    public void createUser_and_deleteUser_happyPath()
    {
        User user = new User("UnitTestUser", "password", 123456789, "0000000000000000");
        userController.createUser(user);
        userRepository.save(user);

        userController.deleteUser(user.id);
        System.out.println("User deleted from Database");
    }

    /**
     * Calling addUser method to test the default add user functionality passing absolute values.
     */
    @Test
    public void addUserTest_happyPath()
    {
        String response = userController.addUser();
        assertTrue(response == "Test User Saved to the Database.");
    }
}
