package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.OrderRepository;
import by.st.deliver.core.entities.Order;
import by.st.deliver.core.mappers.OrderMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataExceptionQ;
import dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getOrderByClientId(Long clientId) {
        List<Order> orders = orderRepository.findAllByClientClientId(clientId);
        if (orders.isEmpty()) {
            throw new NoDataException("There are no orders from client with id " + clientId);
        }
        return orders.stream().map(order -> OrderMapper.INSTANCE.orderToOrderDTO(order)).collect(Collectors.toList());
    }

    @Override
    public Long addOrder(OrderDTO orderDTO) {
        if (orderRepository.findByOrderId(orderDTO.getOrderId()) != null) {
            throw new DataAlreadyExistException("Order with id " + orderDTO.getOrderId() + " already exists");
        }
        orderRepository.save(OrderMapper.INSTANCE.orderDTOToOrder(orderDTO));
        return orderDTO.getOrderId();
    }

    @Override
    public void removeOrder(Long id) {
        if (orderRepository.findByOrderId(id) == null) {
            throw new NoSuchDataExceptionQ("There is no order with id " + id);
        }
        orderRepository.deleteById(id);
        ;

    }

    @Override
    public List<OrderDTO> getOrderByRestaurantId(Long restaurantId) {
        List<Order> orders = orderRepository.findAllByRestaurantRestaurantId(restaurantId);
        if (orders.isEmpty()) {
            throw new NoDataException("There are no orders from restaurant with id " + restaurantId);
        }
        return orders.stream().map(order -> OrderMapper.INSTANCE.orderToOrderDTO(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderByCourierId(Long courierId) {
        List<Order> orders = orderRepository.findAllByClientClientId(courierId);
        if (orders.isEmpty()) {
            throw new NoDataException("There no orders for courier with id " + courierId);
        }
        return orders.stream().map(order -> OrderMapper.INSTANCE.orderToOrderDTO(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderList() {
        List<Order> orders = orderRepository.findAll();
        if (orders.isEmpty()) {
            throw new NoDataException("There no orders on server ");
        }
        return orders.stream().map(order -> OrderMapper.INSTANCE.orderToOrderDTO(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getAllByOrderStatus(String orderStatus) {
        List<Order> orders = orderRepository.findAllByOrderStatus(orderStatus);

        if (orders.isEmpty()) {
            throw new NoDataException("There no orders with order status " + orderStatus);
        }
        return orders.stream().map(order -> OrderMapper.INSTANCE.orderToOrderDTO(order)).collect(Collectors.toList());
    }


    @Override
    public OrderDTO getOrderById(Long orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            throw new NoSuchDataExceptionQ("There is no order with id " + orderId);
        }
        return OrderMapper.INSTANCE.orderToOrderDTO(order);
    }
}
