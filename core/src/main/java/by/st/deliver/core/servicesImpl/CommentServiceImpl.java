package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.CommentRepository;
import by.st.deliver.core.entities.Comment;
import by.st.deliver.core.mappers.CommentMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataExceptionQ;
import dto.CommentDTO;
import dto.CommentRatingUpdateMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.CommentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public Long addComment(CommentDTO commentDTO) {
        Comment comment = CommentMapper.INSTANCE.commentDTOToComment(commentDTO);
        if (commentRepository.findCommentByCommentId(commentDTO.getCommentId()) != null) {
            throw new DataAlreadyExistException("Comment with id " + commentDTO.getCommentId() + " already exists");
        }
        commentRepository.save(comment);
        return commentDTO.getCommentId();
    }

    @Override
    public void removeComment(Long id) {
        if (commentRepository.findCommentByCommentId(id) == null) {
            throw new NoSuchDataExceptionQ("There is no comment with id " + id);
        }
        commentRepository.deleteById(id);

    }

    @Override
    public CommentDTO updateCommentRating(CommentRatingUpdateMessageDTO commentMessageDTO) {
        if (commentRepository.findCommentByCommentId(commentMessageDTO.getId()) == null) {
            throw new NoSuchDataExceptionQ("There is no comment with id " + commentMessageDTO.getId());
        }
        Comment comment = commentRepository.findCommentByCommentId(commentMessageDTO.getId());
        comment.setCommentRating(commentMessageDTO.getNewRating());
        commentRepository.save(comment);
        CommentDTO commentDTO = CommentMapper.INSTANCE.commentToCommentDTO(comment);
        return commentDTO;
    }

    @Override
    public List<CommentDTO> getCommentByProductId(Long productId) {
        List<Comment> comments = commentRepository.findAllByProductProductId(productId);
        if (comments.isEmpty()) {
            throw new NoDataException("There are no comments about product with id " + productId);
        }
        List<CommentDTO> commentDTOS = comments.stream().map(r -> CommentMapper.INSTANCE.commentToCommentDTO(r)).collect(Collectors.toList());
        return commentDTOS;
    }

    @Override
    public List<CommentDTO> getCommentByRestaurantId(Long restaurantId) {
        List<Comment> comments = commentRepository.findAllByRestaurantRestaurantId(restaurantId);

        if (comments.isEmpty()) {
            throw new NoDataException("There are no comments about restaurant with id " + restaurantId);
        }
        List<CommentDTO> commentDTOS = comments.stream().map(r -> CommentMapper.INSTANCE.commentToCommentDTO(r)).collect(Collectors.toList());
        return commentDTOS;
    }

    @Override
    public List<CommentDTO> getCommentByClientId(Long clientId) {
        List<Comment> comments = commentRepository.findAllByClientClientId(clientId);

        if (comments.isEmpty()) {
            throw new NoDataException("There are no comments from client with id " + clientId);
        }
        List<CommentDTO> commentDTOS = comments.stream().map(r -> CommentMapper.INSTANCE.commentToCommentDTO(r)).collect(Collectors.toList());
        return commentDTOS;
    }

    @Override
    public CommentDTO getCommentById(Long commentId) {
        CommentDTO commentDTO = CommentMapper.INSTANCE.commentToCommentDTO(commentRepository.findCommentByCommentId(commentId));
        if (commentDTO == null) {
            new NoSuchDataExceptionQ("There is no comment with id " + commentDTO);
        }
        return commentDTO;
    }
}
