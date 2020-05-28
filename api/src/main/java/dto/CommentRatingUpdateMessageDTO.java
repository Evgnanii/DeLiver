package dto;

import lombok.Data;

@Data
public class CommentRatingUpdateMessageDTO {
    Long id;
    Double newRating;
}
