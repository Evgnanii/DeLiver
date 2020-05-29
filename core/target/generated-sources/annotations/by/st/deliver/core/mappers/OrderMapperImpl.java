package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Client;
import by.st.deliver.core.entities.Courier;
import by.st.deliver.core.entities.Order;
import by.st.deliver.core.entities.OrderStatus;
import by.st.deliver.core.entities.Restaurant;
import dto.OrderDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-28T16:04:57+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO orderToOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setOrderStatus( orderOrderStatusValue( order ) );
        orderDTO.setCourierId( orderCourierCourierId( order ) );
        orderDTO.setClientId( orderClientClientId( order ) );
        orderDTO.setRestaurantId( orderRestaurantRestaurantId( order ) );
        orderDTO.setOrderId( order.getOrderId() );
        orderDTO.setTotalCost( order.getTotalCost() );

        return orderDTO;
    }

    @Override
    public Order orderDTOToOrder(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setRestaurant( orderDTOToRestaurant( orderDTO ) );
        order.setCourier( orderDTOToCourier( orderDTO ) );
        order.setClient( orderDTOToClient( orderDTO ) );
        order.setOrderId( orderDTO.getOrderId() );
        order.setTotalCost( orderDTO.getTotalCost() );
        if ( orderDTO.getOrderStatus() != null ) {
            order.setOrderStatus( Enum.valueOf( OrderStatus.class, orderDTO.getOrderStatus() ) );
        }

        return order;
    }

    private String orderOrderStatusValue(Order order) {
        if ( order == null ) {
            return null;
        }
        OrderStatus orderStatus = order.getOrderStatus();
        if ( orderStatus == null ) {
            return null;
        }
        String value = orderStatus.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    private Long orderCourierCourierId(Order order) {
        if ( order == null ) {
            return null;
        }
        Courier courier = order.getCourier();
        if ( courier == null ) {
            return null;
        }
        Long courierId = courier.getCourierId();
        if ( courierId == null ) {
            return null;
        }
        return courierId;
    }

    private Long orderClientClientId(Order order) {
        if ( order == null ) {
            return null;
        }
        Client client = order.getClient();
        if ( client == null ) {
            return null;
        }
        Long clientId = client.getClientId();
        if ( clientId == null ) {
            return null;
        }
        return clientId;
    }

    private Long orderRestaurantRestaurantId(Order order) {
        if ( order == null ) {
            return null;
        }
        Restaurant restaurant = order.getRestaurant();
        if ( restaurant == null ) {
            return null;
        }
        Long restaurantId = restaurant.getRestaurantId();
        if ( restaurantId == null ) {
            return null;
        }
        return restaurantId;
    }

    protected Restaurant orderDTOToRestaurant(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setRestaurantId( orderDTO.getRestaurantId() );

        return restaurant;
    }

    protected Courier orderDTOToCourier(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Courier courier = new Courier();

        courier.setCourierId( orderDTO.getCourierId() );

        return courier;
    }

    protected Client orderDTOToClient(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setClientId( orderDTO.getClientId() );

        return client;
    }
}
