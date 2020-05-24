package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long productId;

    private String productName;

    private Double cost;

    private Double productRating;

    private String productWeight;

    private Long restaurantId;

    private Long discount;
}
