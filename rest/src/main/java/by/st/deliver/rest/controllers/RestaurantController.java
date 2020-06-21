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
        RestaurantDTO restaurantDTO = restaurantService.getRestaurantById(restaurantId);
        return new ResponseEntity<>(restaurantDTO, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> allRestaurants() {
        List<RestaurantDTO> restaurantDTOS = restaurantService.getRestaurantList();
        return new ResponseEntity<>(restaurantDTOS, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{page}/{kitchen_type}")
    public ResponseEntity<List<RestaurantDTO>> restaurantsByKitchenType(@PathVariable("kitchen_type") String kitchenType,@PathVariable("page") Integer page) {
        List<RestaurantDTO> restaurantDTOS = restaurantService.getRestaurantByKitchenType(kitchenType, page);
        return new ResponseEntity<>(restaurantDTOS, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody @Valid RestaurantDTO restaurantDTO) {
        return new ResponseEntity<>(restaurantDTO, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{restaurant_id}")
    public ResponseEntity<RestaurantDTO> deleteRestaurant(@PathVariable("restaurant_id") Long restaurantId) {
        restaurantService.removeRestaurant(restaurantId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<RestaurantDTO> updateRestaurant(@RequestBody @Valid RestaurantDTO restaurantDTO) {
        RestaurantDTO newRestaurantDTO = restaurantService.updateRestaurant(restaurantDTO);
        return new ResponseEntity<>(newRestaurantDTO, new HttpHeaders(), HttpStatus.OK);
    }
}
