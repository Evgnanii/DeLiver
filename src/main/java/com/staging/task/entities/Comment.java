package com.staging.task.entities;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;
    @Column(name = "comment_text")
    private String commentText;
    @Column(name = "client_id")
    private Long clientId;
    @Enumerated(EnumType.STRING)
    @Column(name = "comment_type")
    private CommentType commentType;
    @Column(name = "comment_rating")
    private Double commentRating;
}
