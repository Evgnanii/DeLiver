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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Client client;
    @Column(name = "comment_rating")
    private Double commentRating;
    @ManyToOne
    @JoinColumn(name = "comment_list_id")
    private CommentList commentList;

}
