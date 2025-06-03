package microservice.statistic;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservice.statistic.entity.Statistic;
import microservice.statistic.entity.StatisticDto;
import microservice.statistic.entity.StatisticRepository;

@RestController

public class StatisticController {
	@Autowired
	StatisticRepository statisticRepository;

	@PostMapping("/add")
	public ResponseEntity<Statistic> save(@RequestBody Statistic statisticDto) {
		/*
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		*/
		Statistic newStatistic = statisticRepository.save(statisticDto);
		return ResponseEntity.ok(newStatistic);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Statistic>> getAll() {
		return ResponseEntity.ok(statisticRepository.findAll());
	}
	
}
