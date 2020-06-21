package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.CommentRepositoryHibernate;
import by.st.deliver.core.entities.Comment;
import by.st.deliver.core.mappers.CommentMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataException;
import dto.CommentDTO;
import dto.CommentRatingUpdateMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.CommentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepositoryHibernate commentRepositoryHibernate;

    @Override
    public Long addComment(CommentDTO commentDTO) {
        Optional<Comment> comment = Optional.ofNullable(CommentMapper.INSTANCE.commentDTOToComment(commentDTO));
        comment.orElseThrow(() -> new DataAlreadyExistException("Comment with id " + commentDTO.getId() + " already exists"));
        commentRepositoryHibernate.addComment(comment.get());
        return commentDTO.getId();
    }

    @Override
    public void removeComment(Long id) {
        Optional<Comment> comment = Optional.ofNullable(commentRepositoryHibernate.getComment(id));
        comment.orElseThrow(() -> new NoSuchDataException("There is no comment with id " + id));
        commentRepositoryHibernate.removeComment(id);
    }

    @Override
    public CommentDTO updateCommentRating(CommentRatingUpdateMessageDTO commentMessageDTO) {
        Optional<Comment> comment = Optional.ofNullable(commentRepositoryHibernate.getComment(commentMessageDTO.getId()));
        comment.orElseThrow(() -> new NoSuchDataException(("There is no comment with id " + commentMessageDTO.getId())));
        comment.get().setRating(commentMessageDTO.getNewRating());
        commentRepositoryHibernate.updateComment(comment.get());
        CommentDTO commentDTO = CommentMapper.INSTANCE.commentToCommentDTO(comment.get());
        return commentDTO;
    }

    @Override
    public List<CommentDTO> getCommentByProductId(Long productId) {
        Optional<List<Comment>> comments = Optional.ofNullable(commentRepositoryHibernate.getCommentsByProduct(productId));
        comments.orElseThrow(() -> new NoDataException("There are no comments about product with id " + productId));
        List<CommentDTO> commentDTOS = comments.get().stream().map(r -> CommentMapper.INSTANCE.commentToCommentDTO(r)).collect(Collectors.toList());
        return commentDTOS;
    }

    @Override
    public List<CommentDTO> getCommentByRestaurantId(Long restaurantId) {
        Optional<List<Comment>> comments = Optional.ofNullable(commentRepositoryHibernate.getCommentsByRestaurant(restaurantId));
        comments.orElseThrow(() -> new NoDataException("There are no comments about restaurant with id " + restaurantId));
        List<CommentDTO> commentDTOS = comments.get().stream().map(r -> CommentMapper.INSTANCE.commentToCommentDTO(r)).collect(Collectors.toList());
        return commentDTOS;
    }

    @Override
    public List<CommentDTO> getCommentByClientId(Long clientId) {
        Optional<List<Comment>> comments = Optional.ofNullable(commentRepositoryHibernate.getCommentsByClient(clientId));
        comments.orElseThrow(() -> new NoDataException("There are no comments from client with id " + clientId));
        List<CommentDTO> commentDTOS = comments.get().stream().map(r -> CommentMapper.INSTANCE.commentToCommentDTO(r)).collect(Collectors.toList());
        return commentDTOS;
    }

    @Override
    public CommentDTO getCommentById(Long commentId) {
        Optional<CommentDTO> commentDTO = Optional.ofNullable(CommentMapper.INSTANCE.commentToCommentDTO(commentRepositoryHibernate.getComment(commentId)));
        commentDTO.orElseThrow(() -> new NoSuchDataException("There is no comment with id " + commentDTO));
        return commentDTO.get();
    }
}
