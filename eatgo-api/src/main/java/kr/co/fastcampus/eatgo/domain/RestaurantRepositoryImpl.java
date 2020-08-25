package kr.co.fastcampus.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// 하나의 인터페이스에 하나의 구현체는
// 의존관계를 줄이는 효과도, 다형성을 주는 효과도 없다.
// 그래서 Impl 레이어가 필요하지 않는다.
@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {
	private List<Restaurant> restaurants = new ArrayList<>();

	public RestaurantRepositoryImpl() {
		restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
		restaurants.add(new Restaurant(2020L, "Martin", "Seoul"));
	}

	@Override
	public List<Restaurant> findAll() {
		return restaurants;
	}

	@Override
	public Restaurant findById(Long id) {
		return restaurants.stream()
			.filter(restaurant -> restaurant.getId().equals(id))
			.findFirst()
			.orElse(null);
	}

	@Override
	public Restaurant save(Restaurant restaurant) {
		restaurant.setId(1234);
		restaurants.add(restaurant);
		return restaurant;
	}
}
