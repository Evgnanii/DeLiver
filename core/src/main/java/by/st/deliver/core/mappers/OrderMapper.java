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

    @Mappings({@Mapping(source = "courier.id", target = "courierId"),
            @Mapping(source = "restaurant.id", target = "restaurantId"),
            @Mapping(source = "client.id", target = "clientId"), @Mapping(source = "status.value", target = "status")})
    OrderDTO orderToOrderDTO(Order order);

    @Mappings({@Mapping(source = "courierId", target = "courier.id"),
            @Mapping(source = "restaurantId", target = "restaurant.id"),
            @Mapping(source = "clientId", target = "client.id")})
    Order orderDTOToOrder(OrderDTO orderDTO);


}
