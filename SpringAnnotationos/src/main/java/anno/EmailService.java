package anno;

import org.springframework.stereotype.Component;

@Component
public class EmailService {
    public  void send(){
        System.out.println("Email sent from email service");
    }


}
