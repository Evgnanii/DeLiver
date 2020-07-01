package services;

import dto.OrderDTO;

import java.util.List;

public interface OrderService {

    public List<OrderDTO> getOrderByClientId(Long clientId, Integer page);

    OrderDTO getCurrentOrderByClientId(Long clientId);

    public Long addOrder(OrderDTO orderDTO);

    public void removeOrder(Long id);

    public List<OrderDTO> getOrderByRestaurantId(Long restaurantId, Integer page);

    public List<OrderDTO> getOrderByCourierId(Long courierId, Integer page);

    public List<OrderDTO> getOrderList();

    public List<OrderDTO> getAllByOrderStatus(String orderStatus, Integer page);

    public OrderDTO getOrderById(Long orderId);

    public Long releaseOrder(Long orderId);

    public Long completeOrder(Long orderId);

    public List<OrderDTO> getAllForCouriers( Integer page);

    Long payOrder(Long orderId);

    Long takeOrder(Long orderId, Long courierId);

}
