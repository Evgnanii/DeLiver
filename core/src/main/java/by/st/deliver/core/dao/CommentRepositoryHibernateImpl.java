package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Comment;

import by.st.deliver.core.entities.PrivilegeLevel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommentRepositoryHibernateImpl implements CommentRepositoryHibernate {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void addComment(Comment comment) {
        entityManager.persist(comment);
        return;
    }

    @Override
    public Comment updateComment(Comment comment) {
        entityManager.merge(comment);
        return comment;
    }

    @Override
    public void removeComment(Long id) {
        Comment comment = entityManager.find(Comment.class, id);
        entityManager.remove(comment);
    }

    @Override
    public Comment getComment(Long id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public List<Comment> getCommentsByProduct(Long productId) {
        return entityManager.createQuery("select c FROM Comment c where c.product.id=?1 ").setParameter(1, productId).getResultList();
    }

    @Override
    public List<Comment> getCommentsByRestaurant(Long restaurantId) {
        return entityManager.createQuery("select c FROM Comment c where c.restaurant.id=?1 ").setParameter(1, restaurantId).getResultList();
    }


    @Override
    public List<Comment> getCommentsByClient(Long clientId) {
        return entityManager.createQuery("select c FROM Comment c where c.client.id=?1 ").setParameter(1, clientId).getResultList();
    }
}
