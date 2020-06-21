package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.OrderRepository;
import by.st.deliver.core.entities.Order;
import by.st.deliver.core.entities.OrderStatus;
import by.st.deliver.core.mappers.OrderMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataException;
import dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import services.OrderService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getOrderByClientId(Long clientId, Integer page) {
        Optional<List<Order>> orders = Optional.ofNullable(orderRepository.findAllByClientId(clientId, PageRequest.of(page, 5)));
        orders.orElseThrow(() -> new NoDataException("There are no orders from client with id " + clientId));
        return orders.get().stream().map(order -> OrderMapper.INSTANCE.orderToOrderDTO(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getCurrentOrderByClientId(Long clientId, Integer page) {
        Optional<List<Order>> optionalOrders = Optional.ofNullable(orderRepository.findAllByClientId(clientId, PageRequest.of(page,5)));
        optionalOrders.orElseThrow(() -> new NoDataException("There are no orders from client with id " + clientId));
        List<Order> orders = optionalOrders.get();
        Order order = orders
                .stream()
                .filter(order1 -> order1.getStatus().equals("OnRest"))
                .findAny()
                .orElseThrow(() -> new NoSuchDataException("There is no current order"));

        return OrderMapper.INSTANCE.orderToOrderDTO(order);
    }

    @Override
    public Long addOrder(OrderDTO orderDTO) {
        Optional<Order> order = orderRepository.findById(orderDTO.getId());
        if (!order.isPresent()) {
            throw new DataAlreadyExistException("Order with id " + orderDTO.getId() + " already exists");
        }
        orderRepository.save(OrderMapper.INSTANCE.orderDTOToOrder(orderDTO));

        return orderDTO.getId();
    }

    @Override
    public void removeOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        order.orElseThrow(() -> new NoSuchDataException("There is no order with id " + id));
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDTO> getOrderByRestaurantId(Long restaurantId, Integer page) {
        Optional<List<Order>> orders = Optional.ofNullable(orderRepository.findAllByRestaurantId(restaurantId, PageRequest.of(page, 5)));
        orders.orElseThrow(() -> new NoDataException("There are no orders from restaurant with id " + restaurantId));
        return orders.get().stream().map(order -> OrderMapper.INSTANCE.orderToOrderDTO(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderByCourierId(Long courierId, Integer page) {
        Optional<List<Order>> orders = Optional.ofNullable(orderRepository.findAllByCourierId(courierId, PageRequest.of(page, 5)));
        orders.orElseThrow(() -> new NoDataException("There no orders for courier with id " + courierId));
        return orders.get().stream().map(order -> OrderMapper.INSTANCE.orderToOrderDTO(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderList() {
        Optional<List<Order>> orders = Optional.ofNullable(orderRepository.findAll());
        orders.orElseThrow(() -> new NoDataException("There no orders on server "));
        return orders.get().stream().map(order -> OrderMapper.INSTANCE.orderToOrderDTO(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getAllByOrderStatus(String orderStatus, Integer page) {
        Optional<List<Order>> orders = Optional.ofNullable(orderRepository.findAllByStatus(orderStatus, PageRequest.of(page, 5)));
        orders.orElseThrow(() -> new NoDataException("There no orders with order status " + orderStatus));
        return orders.get().stream().map(order -> OrderMapper.INSTANCE.orderToOrderDTO(order)).collect(Collectors.toList());
    }


    @Override
    public OrderDTO getOrderById(Long orderId) {
        Optional<Order> order = Optional.ofNullable(orderRepository.findOrderById(orderId));
        order.orElseThrow(() -> new NoSuchDataException("There is no order with id " + orderId));
        return OrderMapper.INSTANCE.orderToOrderDTO(order.get());
    }

    @Override
    public Long releaseOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        optionalOrder.orElseThrow(() -> new NoSuchDataException("There is no order with id " + orderId));
        Order order = optionalOrder.get();
        order.setStatus(OrderStatus.ONPATH);
        orderRepository.save(order);
        return orderId;
    }

    @Override
    public Long completeOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        optionalOrder.orElseThrow(() -> new NoSuchDataException("There is no order with id " + orderId));
        Order order = optionalOrder.get();
        order.setStatus(OrderStatus.COMPLETE);
        orderRepository.save(order);
        return orderId;
    }

    @Override
    public List<OrderDTO> getAllForCouriers(Integer page) {
        Optional<List<Order>> orders = Optional.ofNullable(orderRepository.findAllByStatus(String.valueOf(OrderStatus.ONREST), PageRequest.of(page, 5)));
        orders.orElseThrow(() -> new NoDataException("There are no orders without courier "));
        return orders.get().stream().map(order -> OrderMapper.INSTANCE.orderToOrderDTO(order)).collect(Collectors.toList());
    }
}
