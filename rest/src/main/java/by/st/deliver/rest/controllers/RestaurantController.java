package by.st.deliver.rest.controllers;

import dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.RestaurantService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurants/")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/{restaurant_id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable("restaurant_id") Long restaurantId) {

        if (restaurantService.getRestaurantById(restaurantId) != null) {
            RestaurantDTO restaurantDTO = restaurantService.getRestaurantById(restaurantId);
            return new ResponseEntity<>(restaurantDTO, new HttpHeaders(), HttpStatus.OK);
        } else
            throw new RuntimeException();
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> allRestaurants() {
        List<RestaurantDTO> restaurantDTOS = restaurantService.getRestaurantList();
        if (restaurantDTOS != null) {
            return new ResponseEntity<>(restaurantDTOS, new HttpHeaders(), HttpStatus.OK);
        }
        throw new RuntimeException();
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody @Valid RestaurantDTO restaurantDTO) {
        if (restaurantService.addRestaurant(restaurantDTO)!=null){
            return new ResponseEntity<>(restaurantDTO,new HttpHeaders(), HttpStatus.CREATED);
        }
        throw new RuntimeException();
    }

    @DeleteMapping("/{restaurant_id}")
    public ResponseEntity<RestaurantDTO> deleteRestaurant(@PathVariable("restaurant_id") Long restaurantId) {
        if (restaurantService.getRestaurantById(restaurantId) != null) {
            restaurantService.removeRestaurant(restaurantId);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<RestaurantDTO> updateRestaurant(@RequestBody @Valid RestaurantDTO restaurantDTO) {
        RestaurantDTO newRestaurantDTO = restaurantService.updateRestaurant(restaurantDTO);
        if (newRestaurantDTO != null){
            return new ResponseEntity<>(newRestaurantDTO, new HttpHeaders(), HttpStatus.OK);}
        else throw new RuntimeException();
    }
}
