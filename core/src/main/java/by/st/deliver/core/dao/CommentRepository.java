package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentByCommentId(Long id);
    Iterable<Comment> findAllByRestaurantRestaurantId(Long restaurantId);
    Iterable<Comment> findAllByProductProductId(Long productId);

}
