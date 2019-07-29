package controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.SmsMessageRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="mvdb1.database.windows.net", allowedHeaders="*", methods = { GET, POST, PUT, DELETE, OPTIONS})
public class SmsMessageController {

    public SmsMessageController(SmsMessageRepository smsMessageRepository) {
        this.smsMessageRepository = smsMessageRepository;
    }

    public static final String ACCOUNT_SID = "ACcf98df9b77bc8868c6bff6d34a20b0b2";
    public static final String AUTH_TOKEN = "d98d003674b88128b76409b8fcb61cd5";

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @GetMapping("/messages")
    public List<SmsMessage> getMessages(){
        return smsMessageRepository.findAll();
    }

    @GetMapping("/messages/{id}")
    public Optional<SmsMessage> getMessage(@PathVariable Long id){
        return smsMessageRepository.findById(id);
    }

    @DeleteMapping("/messages/{id}")
    public boolean deleteMessage(@PathVariable Long id){
        smsMessageRepository.deleteById(id);
        return true;
    }

    @PutMapping("/messages/update")
    public SmsMessage updateMessage(@RequestBody SmsMessage smsMessage){
        return smsMessageRepository.save(smsMessage);
    }

    @PostMapping("/messages/create")
    public SmsMessage createMessage(@RequestBody SmsMessage smsMessage){
        return smsMessageRepository.save(smsMessage);
    }

    @RequestMapping("/messages/add")
    public String addMessage(){
        SmsMessage smsMessage = new SmsMessage(1, "Jake", 879592297, "This a test Text Message!", new Date(System.currentTimeMillis()));
        smsMessageRepository.save(smsMessage);
        return "Message successfully saved to the database";
    }

    @RequestMapping("/messages/sendSmsMessage/{phoneNumber}/{smsMessage}")
    public String sendSmsMessage(@PathVariable long phoneNumber, @PathVariable String smsMessage){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                // To Phone Number
                new PhoneNumber("+3530" + phoneNumber),
                // From Phone Number
                new PhoneNumber("+19318054488"),
                // Message
                smsMessage
        ).create();

        return message.getSid();
    }
}
