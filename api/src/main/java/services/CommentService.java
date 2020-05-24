package services;


import dto.CommentDTO;
import dto.CommentMessageDTO;

import java.util.List;

public interface CommentService {
    public CommentDTO addComment(CommentDTO commentDTO);
    public void removeComment(Long id);
    public CommentDTO updateCommentRating(CommentMessageDTO commentMessageDTO);
    public List<CommentDTO> getCommentByProductId(Long productId);
    public List<CommentDTO> getCommentByRestaurantId(Long restaurantId);
}
