package dto;

import lombok.Data;

@Data
public class RestaurantDTO {

    private Long restaurantId;

    private String restaurantName;

    private String restaurantKitchenType;

    private String restaurantPhoneNumber;

    private String restaurantAddress;

    private Double rating;

}
