package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInBasketDTO {
    private Long productInBasketId;
    private Long orderId;
    private Long productId;
    private Long count;

}
