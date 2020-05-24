package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.CommentRepository;
import by.st.deliver.core.entities.Comment;
import by.st.deliver.core.entities.Product;
import by.st.deliver.core.mappers.CommentMapper;
import by.st.deliver.core.mappers.ProductMapper;
import dto.CommentDTO;
import dto.CommentMessageDTO;
import dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.CommentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public CommentDTO addComment(CommentDTO commentDTO) {
        Comment comment = CommentMapper.INSTANCE.commentDTOToComment(commentDTO);
        commentRepository.save(comment);
        return commentDTO;
    }

    @Override
    public void removeComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDTO updateCommentRating(CommentMessageDTO commentMessageDTO) {
        CommentDTO commentDTO;
        Comment comment;
        comment = commentRepository.findCommentByCommentId(commentMessageDTO.getId());
        comment.setCommentRating(commentMessageDTO.getNewRating());
        commentRepository.save(comment);
        commentDTO = CommentMapper.INSTANCE.commentToCommentDTO(comment);
        return commentDTO;
    }

    @Override
    public List<CommentDTO> getCommentByProductId(Long productId) {
        List<Comment> comments = (List<Comment>) commentRepository.findAllByProductProductId(productId);
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            commentDTOS.add(CommentMapper.INSTANCE.commentToCommentDTO(comments.get(i)));
        }
        return commentDTOS;
    }

    @Override
    public List<CommentDTO> getCommentByRestaurantId(Long restaurantId) {
        List<Comment> comments = (List<Comment>) commentRepository.findAllByRestaurantRestaurantId(restaurantId);
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            commentDTOS.add(CommentMapper.INSTANCE.commentToCommentDTO(comments.get(i)));
        }
        return commentDTOS;
    }
}
