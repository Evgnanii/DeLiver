package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Client;
import by.st.deliver.core.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    Restaurant findByRestaurantId(Long id);
}
