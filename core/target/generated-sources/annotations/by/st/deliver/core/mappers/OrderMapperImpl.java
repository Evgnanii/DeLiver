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
    date = "2020-07-01T14:00:17+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO orderToOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setCourierId( orderCourierId( order ) );
        orderDTO.setClientId( orderClientId( order ) );
        orderDTO.setRestaurantId( orderRestaurantId( order ) );
        orderDTO.setStatus( orderStatusValue( order ) );
        orderDTO.setId( order.getId() );
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
        order.setId( orderDTO.getId() );
        order.setTotalCost( orderDTO.getTotalCost() );
        if ( orderDTO.getStatus() != null ) {
            order.setStatus( Enum.valueOf( OrderStatus.class, orderDTO.getStatus() ) );
        }

        return order;
    }

    private Long orderCourierId(Order order) {
        if ( order == null ) {
            return null;
        }
        Courier courier = order.getCourier();
        if ( courier == null ) {
            return null;
        }
        Long id = courier.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long orderClientId(Order order) {
        if ( order == null ) {
            return null;
        }
        Client client = order.getClient();
        if ( client == null ) {
            return null;
        }
        Long id = client.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long orderRestaurantId(Order order) {
        if ( order == null ) {
            return null;
        }
        Restaurant restaurant = order.getRestaurant();
        if ( restaurant == null ) {
            return null;
        }
        Long id = restaurant.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String orderStatusValue(Order order) {
        if ( order == null ) {
            return null;
        }
        OrderStatus status = order.getStatus();
        if ( status == null ) {
            return null;
        }
        String value = status.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    protected Restaurant orderDTOToRestaurant(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setId( orderDTO.getRestaurantId() );

        return restaurant;
    }

    protected Courier orderDTOToCourier(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Courier courier = new Courier();

        courier.setId( orderDTO.getCourierId() );

        return courier;
    }

    protected Client orderDTOToClient(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( orderDTO.getClientId() );

        return client;
    }
}
