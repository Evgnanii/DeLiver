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
public class CommentDTO {
    @NotNull
    @Positive
    private Long id;
    @NotNull
    private String text;
    @NotNull
    private Long clientId;
    @PositiveOrZero
    private Double rating;
    @Positive
    private Long restaurantId;
    @Positive
    private Long productId;
}
