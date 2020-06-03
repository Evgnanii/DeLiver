package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByRestaurantId(Long restaurantId);

    List<Order> findAllByCourierId(Long courierId);

    List<Order> findAllByClientId(Long clientId);

    Order findOrderById(Long orderId);

    List<Order> findAllByStatus(String orderStatus);

    }
