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
public class SmsMessageTest {

    @Mock
    SmsMessage smsMessage;
    SmsMessage smsMessage1;

    public long id = 9999;
    public String username = "TestUser";
    public long phoneNumber = 123456789;
    public String message = "TestMessage";
    public Date textDate = new Date(System.currentTimeMillis());

    @Test
    public void smsMessageConstructor_and_smsMessageGetTest_happyPath()
    {
        smsMessage = new SmsMessage(id, username, phoneNumber, message, textDate);

        assertEquals(smsMessage.getId(), id);
        assertEquals(smsMessage.getUsername(), username);
        assertEquals(smsMessage.getPhoneNumber(), phoneNumber);
        assertEquals(smsMessage.getMessage(), message);
        assertEquals(smsMessage.getTextDate(), textDate);
    }

    @Test
    public void smsMessageSetIDTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        smsMessage = new SmsMessage();
        smsMessage.setId(id);

        final Field field = smsMessage.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("fields don't match", field.get(smsMessage), id);
    }

    @Test
    public void smsMessageSetUsernameTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        smsMessage = new SmsMessage();
        smsMessage.setUsername(username);

        final Field field = smsMessage.getClass().getDeclaredField("username");
        field.setAccessible(true);
        assertEquals("fields don't match", field.get(smsMessage), username);
    }

    @Test
    public void smsMessageSetPhoneNumberTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        smsMessage = new SmsMessage();
        smsMessage.setPhoneNumber(phoneNumber);

        final Field field = smsMessage.getClass().getDeclaredField("phoneNumber");
        field.setAccessible(true);
        assertEquals("fields don't match", field.get(smsMessage), phoneNumber);
    }

    @Test
    public void smsMessageSetMessageTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        smsMessage = new SmsMessage();
        smsMessage.setMessage(message);

        final Field field = smsMessage.getClass().getDeclaredField("message");
        field.setAccessible(true);
        assertEquals("fields don't match", field.get(smsMessage), message);
    }

    @Test
    public void smsMessageSetTextDateTest_happyPath() throws NoSuchFieldException, IllegalAccessException {
        smsMessage = new SmsMessage();
        smsMessage.setTextDate(textDate);

        final Field field = smsMessage.getClass().getDeclaredField("textDate");
        field.setAccessible(true);
        assertEquals("fields don't match", field.get(smsMessage), textDate);
    }

    @Test
    public void smsMessageToStringTest_happyPath()
    {
        smsMessage = new SmsMessage(id, username, phoneNumber, message, textDate);

        assertEquals(smsMessage.toString(), "SmsMessage{" +
        "id=" + id +
                ", username='" + username + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", message='" + message + '\'' +
                ", textDate=" + textDate +
                '}');
    }

    @Test
    public void smsMessageEquals_and_hashCodeTest_happyPath()
    {
        smsMessage = new SmsMessage(id, username, phoneNumber, message, textDate);
        smsMessage1 = new SmsMessage(id, username, phoneNumber, message, textDate);

        assertTrue(smsMessage.equals(smsMessage1));
        assertEquals(smsMessage.hashCode(), smsMessage1.hashCode());
    }

    @Test
    public void smsMessageEquals_and_hashCodeTest_notEquals()
    {
        smsMessage = new SmsMessage(id, username, phoneNumber, message, textDate);
        smsMessage1 = new SmsMessage(id + 1, username, phoneNumber, message, textDate);

        assertFalse(smsMessage.equals(smsMessage1));
        assertNotEquals(smsMessage.hashCode(), smsMessage1.hashCode());
    }
}
