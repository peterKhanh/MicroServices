package cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cloud.entity.MailInfo;


@FeignClient(name="notification-service",  fallback = NotificationServiceIplm.class)
public interface NotificationService {

    @PostMapping("/api/send-notification")
    void sendNotification(@RequestBody MailInfo email );
}
@Component
class NotificationServiceIplm implements NotificationService {

	@Override
	public void sendNotification(MailInfo email) {
		// Fallback
		System.out.println("Notification service is slow");
	}
	
}