package dto;

import lombok.Data;

@Data
public class ProductInBasketDTO {
    private Long productInBasketId;
    private Long orderId;
    private Long productId;
    private Long count;

}
