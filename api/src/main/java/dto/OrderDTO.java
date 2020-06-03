package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    @NotNull
    @Positive
    private Long id;
    @NotNull
    @Positive
    private Long courierId;
    @NotNull
    @Positive
    private Long clientId;
    @NotNull
    @Positive
    private Long restaurantId;
    @NotNull
    @Positive
    private Double totalCost;
    @NotNull
    private String status;

}
