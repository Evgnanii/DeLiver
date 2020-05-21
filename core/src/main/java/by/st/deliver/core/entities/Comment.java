package by.st.deliver.core.entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "comment_text")
    private String commentText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Client client;

    @Column(name = "comment_rating")
    private Double commentRating;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Comment() {
    }

    public Comment(Long commentId, String commentText, Client client, Double commentRating, Restaurant restaurant, Product product) {
        this.commentId = commentId;
        this.commentText = commentText;
        this.client = client;
        this.commentRating = commentRating;
        this.restaurant = restaurant;
        this.product = product;
    }
}
