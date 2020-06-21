package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.RestaurantRepository;
import by.st.deliver.core.entities.Restaurant;
import by.st.deliver.core.mappers.RestaurantMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataException;
import dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import services.RestaurantService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Long addRestaurant(RestaurantDTO restaurantDTO) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantDTO.getId());
        if (optionalRestaurant.isPresent()) {
            throw new DataAlreadyExistException("Restaurant with id " + restaurantDTO.getId() + "already exists");
        }
        restaurantRepository.save(RestaurantMapper.INSTANCE.restaurantDTOToRestaurant(restaurantDTO));
        return restaurantDTO.getId();
    }

    @Override
    public void removeRestaurant(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        restaurant.orElseThrow(() -> new NoSuchDataException("There is no restaurant with id " + id));
        restaurantRepository.deleteById(id);
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
        Optional<Restaurant> restaurant = Optional.ofNullable(RestaurantMapper.INSTANCE.restaurantDTOToRestaurant(restaurantDTO));
        restaurant.orElseThrow(() -> new NoSuchDataException("There is no restaurant with id " + restaurantDTO.getId()));
        restaurantRepository.save(restaurant.get());
        return restaurantDTO;
    }

    @Override
    public List<RestaurantDTO> getRestaurantList() {
        Optional<List<Restaurant>> restaurants = Optional.of(restaurantRepository.findAll());
        restaurants.orElseThrow(() -> new NoDataException("There are no restaurants on server"));
        List<RestaurantDTO> restaurantDTOS = restaurants.get().stream().map(restaurant -> RestaurantMapper.INSTANCE.restaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
        return restaurantDTOS;
    }


    @Override
    public RestaurantDTO getRestaurantById(Long restaurantId) {
        Optional<RestaurantDTO> restaurantDTO = Optional.ofNullable(RestaurantMapper.INSTANCE.restaurantToRestaurantDTO(restaurantRepository.findRestaurantById(restaurantId)));
        restaurantDTO.orElseThrow(() -> new NoSuchDataException("There is no restaurant with id " + restaurantId));
        return restaurantDTO.get();
    }

    @Override
    public List<RestaurantDTO> getRestaurantByKitchenType(String kitchenType, Integer page) {
        Optional<List<Restaurant>> restaurants = Optional.ofNullable(restaurantRepository.findAllByKitchenType(kitchenType, PageRequest.of(page, 5)));
        restaurants.orElseThrow(() -> new NoDataException("There are no restaurants with this kitchen type"));
        List<RestaurantDTO> restaurantDTOS = restaurants.get().stream().map(restaurant -> RestaurantMapper.INSTANCE.restaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
        return restaurantDTOS;
    }
}
