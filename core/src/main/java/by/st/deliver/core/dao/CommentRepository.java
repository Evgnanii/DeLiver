package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentById(Long id);
    List<Comment> findAllByRestaurantId(Long restaurantId);
    List<Comment> findAllByProductId(Long productId);
    List<Comment> findAllByClientId(Long clientId);

}
