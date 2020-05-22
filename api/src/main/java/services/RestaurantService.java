package services;


import dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {
    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO);
    public void removeRestaurant(Long id);
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO);
    public List<RestaurantDTO> getRestaurantList();
    public RestaurantDTO getRestaurantById(Long restaurantId);
}
