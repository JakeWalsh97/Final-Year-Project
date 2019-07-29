package controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TextMessage {
    public static final String ACCOUNT_SID = "AC65b27550e9e2917c52fd6d719d469d8f";
    public static final String AUTH_TOKEN = "44c026b5928bca97e4bd678785150207";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                // To Phone Number
                new PhoneNumber("+3530879592297"),
                // From Phone Number
                new PhoneNumber("+19318054488"),
                // Message
                "Hello Jordan!! Filthy."
        ).create();

        System.out.println(message.getSid());
    }
}
