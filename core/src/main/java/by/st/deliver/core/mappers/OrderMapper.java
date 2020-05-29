package by.st.deliver.core.mappers;


import by.st.deliver.core.entities.Order;
import dto.OrderDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;



@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mappings({@Mapping(source = "courier.courierId", target = "courierId"),
            @Mapping(source = "restaurant.restaurantId", target = "restaurantId"),
            @Mapping(source = "client.clientId", target = "clientId"), @Mapping(source = "orderStatus.value", target = "orderStatus")})
    OrderDTO orderToOrderDTO(Order order);

    @Mappings({@Mapping(source = "courierId", target = "courier.courierId"),
            @Mapping(source = "restaurantId", target = "restaurant.restaurantId"),
            @Mapping(source = "clientId", target = "client.clientId")})
    Order orderDTOToOrder(OrderDTO orderDTO);


}
