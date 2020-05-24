package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {

    private Long restaurantId;

    private String restaurantName;

    private String restaurantKitchenType;

    private String restaurantPhoneNumber;

    private String restaurantAddress;

    private Double rating;

}
