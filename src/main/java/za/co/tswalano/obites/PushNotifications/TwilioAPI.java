package za.co.tswalano.obites.PushNotifications;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioAPI {

    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "";
    public static final String AUTH_TOKEN = "";

    //    Send an SMS
    public static void sendTwilioSMS(String number) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber(number),  //to
                new PhoneNumber("+12014254388"),  //from
                "O-Bite Application Successfully Booted!!").create(); //message

        System.out.println(message.getSid());
    }

    //    Send a WhatsApp
    public static void sendTwilioWhatsapp(String number) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:"+number), //to
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), //from
                "O-Bite Application Successfully Booted!!").create(); //message

        System.out.println(message.getSid());
    }
}
