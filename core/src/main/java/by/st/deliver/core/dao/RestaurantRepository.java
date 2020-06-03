package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findRestaurantById(Long id);

    List<Restaurant> findAllByKitchenType(String kitchenType);
}
