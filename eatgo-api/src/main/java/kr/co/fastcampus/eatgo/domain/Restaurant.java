package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String address;

	@Transient
	@JsonInclude(Include.NON_NULL) // Null 일 경우에는 JSON 응답 값에 넣어주지 않는다.
	private List<MenuItem> menuItems = new ArrayList<>();

	public Restaurant() {
	}

	public Restaurant(String name) {
		this(name, "");
	}

	public Restaurant(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public Restaurant(Long id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public String getInformation() {
		return name + " in " +  this.address;
	}

	public String getAddress() {
		return this.address;
	}

	public Long getId() {
		return id;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void addMenuItem(MenuItem menuItem) {
		menuItems.add(menuItem);
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		for (MenuItem menuItem: menuItems) {
			addMenuItem(menuItem);
		}
	}

	public void setId(long id) {
		this.id = id;
	}
}
