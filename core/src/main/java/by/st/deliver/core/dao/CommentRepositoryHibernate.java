package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentRepositoryHibernate {
    void addComment(Comment comment);

    Comment updateComment(Comment comment);

    void removeComment(Long id);

    Comment getComment(Long id);

    List<Comment> getCommentsByProduct(Long productId);

    List<Comment> getCommentsByClient(Long clientId);

    List<Comment> getCommentsByRestaurant(Long restaurantId);


}
