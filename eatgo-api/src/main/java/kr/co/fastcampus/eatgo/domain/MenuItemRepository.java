package kr.co.fastcampus.eatgo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
	List<MenuItem> findAllByRestaurantId(Long id);
}
