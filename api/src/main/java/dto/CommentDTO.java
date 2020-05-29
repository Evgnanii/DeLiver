package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private Long commentId;

    private String commentText;

    private Long clientId;

    private Double commentRating;

    private Long restaurantId;

    private Long productId;
}
