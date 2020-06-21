package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByRestaurantId(Long restaurantId, Pageable pageable);

    List<Order> findAllByCourierId(Long courierId, Pageable pageable);

    List<Order> findAllByClientId(Long clientId, Pageable pageable);

    Order findOrderById(Long orderId);

    List<Order> findAllByStatus(String orderStatus, Pageable pageable);

}
