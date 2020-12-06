package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MenuItem {

	@Id
	@GeneratedValue
	private Long id;
	private Long restaurantId;
	private String name;

	@JsonInclude(Include.NON_DEFAULT) // Default 값이 아니면 JSON 에 넣어준다
	private boolean deleted;

	public MenuItem(String name) {
		this.name = name;
	}

	@Builder
	public MenuItem(Long id, Long restaurantId, String name, boolean deleted) {
		this.id = id;
		this.restaurantId = restaurantId;
		this.name = name;
		this.deleted = deleted;
	}
}
