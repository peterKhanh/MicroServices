package cloud;

import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.logging.*;

import cloud.entity.Statistic;


@FeignClient(name="statistic-service", url = "http://localhost:9082", fallback = StatisticServiceIplm.class)
public interface StatisticService {
	@PostMapping("/add")
	void save(@RequestBody Statistic statistic); 
}
@Component
class StatisticServiceIplm implements StatisticService{
//	Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	@Override
	public void save(Statistic statistic) {
		// Fall back
		System.out.println("Statistic service is slow");
	}
	
}
