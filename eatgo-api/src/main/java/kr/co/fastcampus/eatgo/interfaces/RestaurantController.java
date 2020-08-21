package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.RestaurantService;
import kr.co.fastcampus.eatgo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

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
		List<Restaurant> restaurants = restaurantService.getRestaurants();
		return restaurants;
	}

	@GetMapping("/restaurants/{id}")
	public Restaurant detail (@PathVariable("id") Long id) {
		Restaurant restaurant = restaurantService.getRestaurant(id); // 컬렉션과 같은 역할을 함

		return restaurant;
	}

	@PostMapping("/restaurants")
	public ResponseEntity<String> create (@RequestBody Restaurant restaurant) throws URISyntaxException {
		restaurantService.addRestaurant(restaurant);

		URI location = new URI("/restaurants/" + restaurant.getId());
		return ResponseEntity.created(location).body("생성!");
	}
}
