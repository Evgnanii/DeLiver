package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInBasketDTO {
    @NotNull
    @Positive
    private Long productInBasketId;
    @NotNull
    @Positive
    private Long orderId;
    @NotNull
    @Positive
    private Long productId;
    @NotNull
    @PositiveOrZero
    private Long count;

}
