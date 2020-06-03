package dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public class CommentRatingUpdateMessageDTO {
    @NotNull
    @Positive
    Long id;
    @PositiveOrZero
    @NotNull
    Double newRating;
}
