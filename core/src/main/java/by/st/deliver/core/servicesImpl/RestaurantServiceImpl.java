package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.RestaurantRepository;
import by.st.deliver.core.entities.Restaurant;
import by.st.deliver.core.mappers.RestaurantMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataExceptionQ;
import dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.RestaurantService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Long addRestaurant(RestaurantDTO restaurantDTO) {
        if (restaurantRepository.findById(restaurantDTO.getRestaurantId()) != null) {
            throw new DataAlreadyExistException("Restaurant with id " + restaurantDTO.getRestaurantId() + "already exists");
        }
        restaurantRepository.save(RestaurantMapper.INSTANCE.restaurantDTOToRestaurant(restaurantDTO));
        return restaurantDTO.getRestaurantId();
    }

    @Override
    public void removeRestaurant(Long id) {

        if (restaurantRepository.findById(id) == null) {
            throw new NoSuchDataExceptionQ("There is no restaurant with id " + id);
        }
        restaurantRepository.deleteById(id);
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = RestaurantMapper.INSTANCE.restaurantDTOToRestaurant(restaurantDTO);
        if (restaurantRepository.findById(restaurantDTO.getRestaurantId()) == null) {
            throw new NoSuchDataExceptionQ("There is no restaurant with id " + restaurantDTO.getRestaurantId());
        }
        restaurantRepository.save(restaurant);
        return restaurantDTO;
    }

    @Override
    public List<RestaurantDTO> getRestaurantList() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        if (restaurants.isEmpty()) {
            throw new NoDataException("There are no restaurants on server");
        }
        List<RestaurantDTO> restaurantDTOS = restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.restaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
        return restaurantDTOS;
    }


    @Override
    public RestaurantDTO getRestaurantById(Long restaurantId) {
        RestaurantDTO restaurantDTO = RestaurantMapper.INSTANCE.restaurantToRestaurantDTO(restaurantRepository.findRestaurantByRestaurantId(restaurantId));
        if (restaurantDTO == null) {
            throw new NoSuchDataExceptionQ("There is no restaurant with id " + restaurantId);
        }
        return restaurantDTO;
    }
}
