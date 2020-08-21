package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.RestaurantService;
import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class) // 해당 컨트롤러를 테스트 하겠다 라는 의미
class RestaurantControllerTest {
	// service 를 활용한다 정도만 테스트

	@Autowired
	private MockMvc mvc;

	@MockBean
	private RestaurantService restaurantService;	// 가짜 Service 를 주입하기 때문에 실제 repository 사용 X

	@Test
	public void 리스트_받아오기 () throws Exception {
		// Mock 데이터 주입을 위한 객체
		List<Restaurant> restaurants = new ArrayList<>();
		restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));

		// Mock 데이터 주입
		given(restaurantService.getRestaurants()).willReturn(restaurants);

		mvc.perform(get("/restaurants"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("\"id\":1004")))
			.andExpect(content().string(containsString("\"name\":\"Bob zip\"")));
	}

	@Test
	public void 가게상세_받아오기 () throws Exception {
		// Mock 데이터 주입을 위한 객체
		Restaurant restaurant1 = new Restaurant(1004L, "Bob zip", "Seoul");
		Restaurant restaurant2 = new Restaurant(2020L, "Martin", "Seoul");
		restaurant1.addMenuItem(new MenuItem("Kimchi"));

		// Mock 데이터 주입
		given(restaurantService.getRestaurant(1004L)).willReturn(restaurant1);
		given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);

		mvc.perform(get("/restaurants/1004"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("\"id\":1004")))
			.andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
			.andExpect(content().string(
				containsString("Kimchi")
			))

		;

		mvc.perform(get("/restaurants/2020"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("\"id\":2020")))
			.andExpect(content().string(containsString("\"name\":\"Martin\"")));
	}

	@Test
	public void 레스토랑_생성 () throws Exception {
		mvc.perform(
			post("/restaurants")
				.content("{\"name\": \"BeRyong\", address: \"Seoul\"}")
				.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isCreated())
			.andExpect(header().string("location", "/restaurants/1234"))
			.andExpect(content().string("생성!"));

		verify(restaurantService).addRestaurant(any()); // 호출 여부만 판단
	}

}
