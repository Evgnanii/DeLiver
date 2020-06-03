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
public class  ProductDiscountUpdateMessage {
    @NotNull
    @Positive
    Long productId;
    @NotNull
    @PositiveOrZero
    Long discount;
}
