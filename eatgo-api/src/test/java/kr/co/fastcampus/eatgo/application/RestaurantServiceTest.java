package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class RestaurantServiceTest {
	private RestaurantService restaurantService;
	@Mock
	private RestaurantRepository restaurantRepository;
	@Mock
	private MenuItemRepository menuItemRepository;

	@BeforeEach // TODO Before 은 왜 안되는지 확인할 것
	public void 셋업 () {
		MockitoAnnotations.initMocks(this);			// Mockito 어노테이션이 붙어있는 것들을 초기화 해줌

		// 각각의 repository mock 처리
		mockRestaurantRepository();
		mockMenuItemRepository();

		restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
	}

	private void mockRestaurantRepository() {
		// ============ Mock 데이터 주입을 위한 객체 ============
		List<Restaurant> restaurants = new ArrayList<>();
		Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
		restaurants.add(restaurant);
		given(restaurantRepository.findAll()).willReturn(restaurants);
		given(restaurantRepository.findById(1004L)).willReturn(restaurant);
	}

	private void mockMenuItemRepository () {
		// ============ Mock 데이터 주입을 위한 객체 ============
		List<MenuItem> menuItems = new ArrayList<>();
		menuItems.add(new MenuItem("Kimchi"));

		given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItems);
	}

	@Test
	public void 레스트랑_리스트_정보_얻기 () {
		List<Restaurant> restaurants = restaurantService.getRestaurants();
		Restaurant restaurant = restaurants.get(0);
		assertThat(restaurant.getId(), is(1004L));
	}

	@Test
	public void 레스트랑_정보_얻기 () {
		Restaurant restaurant = restaurantService.getRestaurant(1004L);
		assertThat(restaurant.getId(), is(1004L));

		MenuItem menuItem = restaurant.getMenuItems().get(0);
		assertThat(menuItem.getName(), is("Kimchi"));
	}

	@Test
	public void 레스토랑_생성 () {
		Restaurant restaurant = new Restaurant("BeRyong", "Busan");
		Restaurant saved = new Restaurant(1234L, "BeRyong", "Busan");

		given(restaurantRepository.save(any())).willReturn(saved);

		Restaurant created = restaurantService.addRestaurant(restaurant);

		assertThat(created.getId(), is(1234L));
	}
}
