package services;


import dto.CommentDTO;
import dto.CommentRatingUpdateMessageDTO;

import java.util.List;

public interface CommentService {
    public Long addComment(CommentDTO commentDTO);

    public void removeComment(Long id);

    public CommentDTO updateCommentRating(CommentRatingUpdateMessageDTO commentRatingUpdateMessageDTO);

    public List<CommentDTO> getCommentByProductId(Long productId);

    public List<CommentDTO> getCommentByRestaurantId(Long restaurantId);

    public List<CommentDTO> getCommentByClientId(Long ClientId);

    public CommentDTO getCommentById(Long commentId);

}
