package kr.co.fastcampus.eatgo.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WelcomeController {

	@GetMapping("/")
	public String hello () {
		log.info("test");
		return "Hello, world by Martin !!!";
	}
}

