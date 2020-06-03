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
public class ProductDTO {
    @NotNull
    @Positive
    private Long id;
    private String name;
    @NotNull
    @Positive
    private Double cost;
    @NotNull
    @PositiveOrZero
    private Double rating;
    private String weight;
    @NotNull
    @Positive
    private Long restaurantId;
    @NotNull
    @PositiveOrZero
    private Long discount;
}
