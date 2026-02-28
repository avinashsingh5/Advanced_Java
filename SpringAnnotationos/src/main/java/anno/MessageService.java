package anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private final EmailService emailService;

    @Autowired
    public  MessageService(EmailService emailService){
        this.emailService = emailService;
    }


    public  void sendMessage(){
        System.out.println("Messaging from messageService");
        emailService.send();
    }
}
