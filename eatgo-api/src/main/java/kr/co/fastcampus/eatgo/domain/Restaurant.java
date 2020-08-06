package kr.co.fastcampus.eatgo.domain;

public class Restaurant {
	private final Long id;
	private final String name;
	private final String address;

	public Restaurant(String name) {
		this(name, "");
	}

	public Restaurant(String name, String address) {
		this(1L, name, address);
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
}
