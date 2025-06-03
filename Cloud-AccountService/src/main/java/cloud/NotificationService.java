package cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cloud.entity.MailInfo;
import cloud.entity.Statistic;


@FeignClient(name="notification-service", url = "http://localhost:9083/api")
public interface NotificationService {

    @PostMapping("/send-notification")
    void sendNotification(@RequestBody MailInfo email );
}
