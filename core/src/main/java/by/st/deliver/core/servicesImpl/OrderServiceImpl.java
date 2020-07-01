package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.CourierRepository;
import by.st.deliver.core.dao.OrderRepository;
import by.st.deliver.core.entities.Courier;
import by.st.deliver.core.entities.Order;
import by.st.deliver.core.entities.OrderStatus;
import by.st.deliver.core.mappers.OrderMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataException;
import by.st.deliver.core.servicesImpl.exceptions.OrderAlreadyReleasedException;
import dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import services.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CourierRepository courierRepository;

    @Override
    public List<OrderDTO> getOrderByClientId(Long clientId, Integer page) {
        Optional<List<Order>> orders = Optional.ofNullable(orderRepository.findAllByClientId(clientId, PageRequest.of(page, 5)));
        orders.orElseThrow(() -> new NoDataException("There are no orders from client with id " + clientId));
        return orders.get().stream().map(order -> OrderMapper.INSTANCE.orderToOrderDTO(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getCurrentOrderByClientId(Long clientId) {
        Optional<Order> optionalOrders = Optional.ofNullable(orderRepository.findOrderByClientIdAndStatus(clientId, String.valueOf(OrderStatus.ONREST)));
        optionalOrders.orElseThrow(() -> new NoDataException("There are no orders from client with id " + clientId));
        Order order = optionalOrders.get();
        return OrderMapper.INSTANCE.orderToOrderDTO(order);
    }

    @Override
    public Long addOrder(OrderDTO orderDTO) {
        Optional<Order> order = orderRepository.findById(orderDTO.getId());
        if (!order.equals(Optional.empty())) {
            throw new DataAlreadyExistException("Order with id " + orderDTO.getId() + " already exists");
        }

        Order order1 = orderRepository.save(OrderMapper.INSTANCE.orderDTOToOrder(orderDTO));

        return order1.getId();
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
        Optional<Order> order = orderRepository.findOrderById(orderId);
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

    @Override
    public Long payOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        optionalOrder.orElseThrow(() -> new
                OrderAlreadyReleasedException("There is no order with id " + orderId));

        Order order = optionalOrder.get();
        if (order.getStatus().
                equals(OrderStatus.ONREST)) {
            order.setStatus(OrderStatus.WITHOUTCOURIER);
            orderRepository.save(order);
            return orderId;
        }
        throw new
                OrderAlreadyReleasedException("Order with id " + orderId + " already paid");
    }

    @Override
    public Long takeOrder(Long orderId, Long courierId) {
        Optional<Courier> courier = courierRepository.findById(courierId);
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        optionalOrder.orElseThrow(() -> new NoSuchDataException("There are no order with id " + orderId));
        Order order = optionalOrder.get();
        if (order.getStatus().equals(OrderStatus.WITHOUTCOURIER)) {
            order.setCourier(courier.get());
            orderRepository.save(order);
            return orderId;
        } else throw new OrderAlreadyReleasedException("Order with id " + orderId + " alreadyReleased");
    }


}
