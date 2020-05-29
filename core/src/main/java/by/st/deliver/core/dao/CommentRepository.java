package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentByCommentId(Long id);
    List<Comment> findAllByRestaurantRestaurantId(Long restaurantId);
    List<Comment> findAllByProductProductId(Long productId);
    List<Comment> findAllByClientClientId(Long clientId);

}
