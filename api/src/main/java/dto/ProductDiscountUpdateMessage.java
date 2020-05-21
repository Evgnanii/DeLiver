package dto;

import lombok.Data;

@Data
public class  ProductDiscountUpdateMessage {
    Long productId;
    Long discount;
}
