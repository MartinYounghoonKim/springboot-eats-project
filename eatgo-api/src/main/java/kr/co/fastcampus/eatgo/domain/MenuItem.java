package kr.co.fastcampus.eatgo.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class MenuItem {

	@Id
	@GeneratedValue
	private Long id;
	private Long restaurantId;
	private String name;

	public MenuItem(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Builder
	public MenuItem(Long id, Long restaurantId, String name) {
		this.id = id;
		this.restaurantId = restaurantId;
		this.name = name;
	}
}
