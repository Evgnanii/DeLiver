package com.staging.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comment_list")
public class CommentList {
    @Id
    @GeneratedValue
    @Column(name = "comment_list_id")
    @Getter
    @Setter
    private Long commentListId;
    @Column(name = "comment_type")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    CommentType commentType;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    @Getter
    @Setter
    private Product product;
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = true)
    @Getter
    @Setter
    private Restaurant restaurant;


    public CommentList() {
    }


}
