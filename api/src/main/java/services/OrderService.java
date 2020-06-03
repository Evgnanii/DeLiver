package services;

import dto.ClientDTO;
import dto.ClientDateRangeMessageDTO;
import dto.OrderDTO;

import java.util.List;

public interface OrderService {

    public List<OrderDTO> getOrderByClientId(Long clientId);

    public Long addOrder(OrderDTO orderDTO);

    public void removeOrder(Long id);

    public List<OrderDTO> getOrderByRestaurantId(Long restaurantId);

    public List<OrderDTO> getOrderByCourierId(Long courierId);

    public List<OrderDTO> getOrderList();

    public List<OrderDTO> getAllByOrderStatus(String orderStatus);

    public OrderDTO getOrderById(Long orderId);

    public Long releaseOrder(Long orderId);

    public Long completeOrder(Long orderId);

    public List<OrderDTO> getAllForCouriers();
}
