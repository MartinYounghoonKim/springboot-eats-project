package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
	@Autowired
	private RestaurantRepository restaurantRepository;
	// 수정자 주입
	// 1. Bean 이 없으면 빈 팩토리에 등록
	// 2. 빈 팩토리에 빈을 생성 혹은 등록
	// 3. 의존성을 주입해야할 곳에 주입

	// 필드 주입
	// 1. 빈 팩토리에 빈을 생성 혹은 등록
	// 2. 의존성을 주입해야할 곳에 주입

	// 생성자 주입
	// 1. 생성자의 인자인 Bean 이 없으면 빈 팩토리에 등록
	// 2. 빈의 생성자를 호출


	@GetMapping("/restaurants")
	public List<Restaurant> list () {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return restaurants;
	}

	@GetMapping("/restaurants/{id}")
	public Restaurant detail (@PathVariable("id") Long id) {
		return restaurantRepository.findById(id);
	}
}
