package com.staging.task.entities;

import javax.persistence.*;

@Entity
@Table(name = "comment_list")
public class CommentList {
    @Id
    @GeneratedValue
    @Column(name = "comment_list_id")
    private Long commentListId;
    @Column(name = "comment_type")
    @Enumerated(EnumType.STRING)
    CommentType commentType;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = true)
    private Restaurant restaurant;


    public CommentList() {
    }

    public Long getCommentListId() {
        return commentListId;
    }

    public void setCommentListId(Long commentListId) {
        this.commentListId = commentListId;
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    public CommentList(CommentType commentType) {
        this.commentType = commentType;
    }
}
