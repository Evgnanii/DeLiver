package com.staging.task.entities;

import javax.persistence.*;
@Entity
@Table(name = "comment_list")
public class CommentList {
    @Id
    @GeneratedValue
    @Column(name = "comment_list_id")
    private Long commentListId;
    @Column(name = "commentary_type")
    @Enumerated(EnumType.STRING)
    CommentType commentType;

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
