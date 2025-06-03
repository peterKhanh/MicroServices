package cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cloud.entity.Statistic;


@FeignClient(name="statistic-service", url = "http://localhost:9082")
public interface StatisticService {
	@PostMapping("/add")
	void save(@RequestBody Statistic statistic); 


}
