package cloud;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.entity.Account;
import cloud.entity.MailInfo;
import cloud.entity.Statistic;
import cloud.repository.AccountRepository;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	private StatisticService statisticService;
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping("/")
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	@GetMapping("/all")
	public ResponseEntity<List<Account>> getAllTutorials() {
		return ResponseEntity.ok(accountRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getById(@PathVariable("id") Long id) {
		Optional<Account> accData = accountRepository.findById(id);
		if (accData.isPresent()) {
			return new ResponseEntity<>(accData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/add")
	public ResponseEntity<Account> save(@RequestBody Account accDto) {
		Account newAcc = accountRepository.save(accDto);

		//		Lưu Statistic su dung feign client
		statisticService.save(new Statistic("Account " + accDto.getFirstName() + " được tạo!", new Date()));
		
		List<Statistic> ls =	statisticService.getAll();
		ls.forEach((p) -> {
			System.out.println(p.getMessage());
		});
		
		//		Gui Message su dung feign client
		MailInfo mailInfo = new MailInfo();
		mailInfo.setFrom("tkhn2020@gmail.com");
		mailInfo.setTo("tkhn2020@gmail.com");
		mailInfo.setSubject("Email sent from SpringBoot to " + accDto.getFirstName());
		mailInfo.setBody("Account " + accDto.getFirstName() + " được tạo!");
		notificationService.sendNotification(mailInfo);

		
		return ResponseEntity.ok(newAcc);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try {
			accountRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
