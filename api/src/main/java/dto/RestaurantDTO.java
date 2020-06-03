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
public class RestaurantDTO {
    @NotNull
    @Positive
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String kitchenType;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String address;
    @NotNull
    @PositiveOrZero
    private Double rating;

}
