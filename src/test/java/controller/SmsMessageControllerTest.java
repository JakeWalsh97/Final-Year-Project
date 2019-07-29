package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import repository.SmsMessageRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsMessageControllerTest {

    /**
     * Mocking both the smsMessageController and smsMessageRepository to simulate the real database functionality.
     */
    @Mock
    SmsMessageController smsMessageController;

    @Mock
    SmsMessageRepository smsMessageRepository;

    /**
     * Using a setUp method to initialize the smsMessageController to avoid repeating code.
     */
    @Before
    public void setUp()
    {
        smsMessageController = new SmsMessageController(smsMessageRepository);
    }

    /**
     * Calling getSmsMessages method and returning all smsMessages from the database.
     */
    @Test
    public void getSmsMessages_happyPath()
    {
        List<SmsMessage> response = smsMessageController.getMessages();

        System.out.println(response.toString());
    }

    /**
     * Calling getSmsMessage method and returning a specific smsMessage from database using ID.
     */
    @Test
    public void getSmsMessage_happyPath()
    {
        long id = 1;
        Optional<SmsMessage> response = smsMessageController.getMessage(id);

        System.out.println(response.toString());
    }

    /**
     * Calling createSmsMessage and deleteSmsMessage methods to test the add and delete functionality of the database.
     */
    @Test
    public void createSmsMessage_and_deleteSmsMessageTest_happyPath()
    {
        SmsMessage smsMessage = new SmsMessage(19000, "Test", 123456789, "Test", new Date(System.currentTimeMillis()));
        smsMessageController.createMessage(smsMessage);
        smsMessageRepository.save(smsMessage);

        smsMessageRepository.deleteById(smsMessage.id);
        System.out.println("Sms Message deleted from database!");
    }

    /**
     * Calling addSmsMessage method to test the default add smsMessage functionality passing absolute values.
     */
    @Test
    public void addSmsMessageTest_happyPath()
    {
        String response = smsMessageController.addMessage();

        assertTrue(response == "Message successfully saved to the database");
    }

    /**
     * NB: Cannot test sendSmsMessage() as their is a cost for every text message sent on Twilio
     */
}
