package by.st.deliver.core.mappers;


import by.st.deliver.core.entities.Restaurant;
import dto.RestaurantDTO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
    @Mapping(source = "kitchenType.value", target = "kitchenType")
    RestaurantDTO restaurantToRestaurantDTO(Restaurant restaurant);
    Restaurant restaurantDTOToRestaurant(RestaurantDTO restaurantDTO);
}
