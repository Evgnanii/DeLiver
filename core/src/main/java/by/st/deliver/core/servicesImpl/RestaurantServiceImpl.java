package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.RestaurantRepository;
import by.st.deliver.core.entities.Client;
import by.st.deliver.core.entities.Restaurant;
import by.st.deliver.core.mappers.ClientMapper;
import by.st.deliver.core.mappers.RestaurantMapper;
import dto.ClientDTO;
import dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.RestaurantService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        if (restaurantRepository.findById(restaurantDTO.getRestaurantId()) == null) {
            restaurantRepository.save(RestaurantMapper.INSTANCE.restaurantDTOToRestaurant(restaurantDTO));
            return restaurantDTO;
        }
        return null;
    }

    @Override
    public void removeRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = RestaurantMapper.INSTANCE.restaurantDTOToRestaurant(restaurantDTO);
        if (restaurantRepository.findById(restaurantDTO.getRestaurantId()) != null) {
            restaurantRepository.save(restaurant);
            return restaurantDTO;
        } else return null;
    }

    @Override
    public List<RestaurantDTO> getRestaurantList() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantDTO> restaurantDTOS = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            restaurantDTOS.add(RestaurantMapper.INSTANCE.restaurantToRestaurantDTO(restaurants.get(i)));
        }
        return restaurantDTOS;
    }


    @Override
    public RestaurantDTO getRestaurantById(Long restaurantId) {
        return RestaurantMapper.INSTANCE.restaurantToRestaurantDTO(restaurantRepository.findByRestaurantId(restaurantId));
    }
}
