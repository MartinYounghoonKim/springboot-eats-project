package kr.co.fastcampus.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantRepositoryImplTest {

	@Test
	public void save () {
		RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();
		int oldCount = restaurantRepository.findAll().size();

		Restaurant restaurant = new Restaurant("BeRyong", "Seoul");

		restaurantRepository.save(restaurant);

		assertThat(restaurant.getId(), is(1234L));
		int newCount = restaurantRepository.findAll().size();


		assertThat(newCount - oldCount, is(1));
	}

}
