package dto;

import lombok.Data;


@Data
public class ProductDTO {

    private Long productId;

    private String productName;

    private Double cost;

    private Double productRating;

    private String productWeight;

    private Long restaurantId;

    private Long discount;
}
