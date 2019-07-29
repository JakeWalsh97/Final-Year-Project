package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Mock
    User user;
    User user1;

    public long id = 3333;
    public String username = "TestUser";
    public String password = "TestPassword";
    public long phoneNumber = 123456789;
    public String cardNum = "0000 0000 0000 0000";

    @Test
    public void userConstructor_andUserGetTest_happyPath()
    {
        user = new User(username, password, phoneNumber, cardNum);

        assertEquals(user.getId(), 0);
        assertEquals(user.getUsername(), username);
        assertEquals(user.getPassword(), password);
        assertEquals(user.getPhoneNumber(), phoneNumber);
        assertEquals(user.getCardNum(), cardNum);
    }

    @Test
    public void userSetIDTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        user = new User();
        user.setId(id);

        final Field field = user.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("fields don't match", field.get(user), id);
    }

    @Test
    public void userSetUsernameTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        user = new User();
        user.setUsername(username);

        final Field field = user.getClass().getDeclaredField("username");
        field.setAccessible(true);
        assertEquals("fields don't match", field.get(user), username);
    }

    @Test
    public void userSetPasswordTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        user = new User();
        user.setPassword(password);

        final Field field = user.getClass().getDeclaredField("password");
        field.setAccessible(true);
        assertEquals("fields don't match", field.get(user), password);
    }

    @Test
    public void userSetPhoneNumberTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        user = new User();
        user.setPhoneNumber(phoneNumber);

        final Field field = user.getClass().getDeclaredField("phoneNumber");
        field.setAccessible(true);
        assertEquals("fields don't match", field.get(user), phoneNumber);
    }

    @Test
    public void userSetCardNumTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        user = new User();
        user.setCardNum(cardNum);

        final Field field = user.getClass().getDeclaredField("cardNum");
        field.setAccessible(true);
        assertEquals("fields don't match", field.get(user), cardNum);
    }

    @Test
    public void userToStringTest_happyPath()
    {
        user = new User(username, password, phoneNumber, cardNum);

        assertEquals(user.toString(), "User{" +
        "id=" + 0 +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", cardNum=" + cardNum +
                '}');
    }

    @Test
    public void userEquals_and_hashCodeTest_happyPath()
    {
        user = new User(username, password, phoneNumber, cardNum);
        user1 = new User(username, password, phoneNumber, cardNum);

        assertTrue(user.equals(user1));
        assertEquals(user.hashCode(), user1.hashCode());
    }

    @Test
    public void userEquals_and_hashCodeTest_notEquals()
    {
        user = new User(username, password, phoneNumber, cardNum);
        user1 = new User(username, password, phoneNumber + 1, cardNum);

        assertFalse(user.equals(user1));
        assertNotEquals(user.hashCode(), user1.hashCode());
    }
}
