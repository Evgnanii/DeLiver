package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByRestaurantRestaurantId(Long restaurantId);

    List<Order> findAllByCourierCourierId(Long courierId);

    List<Order> findAllByClientClientId(Long clientId);

    Order findByOrderId(Long restaurantId);

    List<Order> findAllByOrderStatus(String orderStatus);
}
