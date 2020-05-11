package com.staging.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    @Getter
    @Setter
    private Long commentId;
    @Column(name = "comment_text")
    @Getter
    @Setter
    private String commentText;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @Getter
    @Setter
    private Client client;
    @Column(name = "comment_rating")
    @Getter
    @Setter
    private Double commentRating;
    @ManyToOne
    @JoinColumn(name = "comment_list_id")
    @Getter
    @Setter
    private CommentList commentList;

}
