package microservice.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import microservice.notification.*;
@RestController
@RequestMapping("/api")

public class ApiController {
	 
@Autowired
MailService emailService;
	    @PostMapping("/send-notification")
	    public void sendNotification(@RequestBody MailInfo email ) throws MessagingException {
	    	System.out.println(email.getFrom());
	        emailService.send(email);
	    }
	@GetMapping("/")
	public String getAll() {
		return "sdfsdf";
	}
}
