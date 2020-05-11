package com.staging.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "couriers")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courier_id")
    @Getter
    @Setter
    private Long courierId;
    @Column(name = "courier_first_name")
    @Getter
    @Setter
    private String courierFirstName;
    @Column(name = "courier_second_name")
    @Getter
    @Setter
    private String courierSecondName;
    @Column(name = "courier_rating")
    @Getter
    @Setter
    private Double courierRating;
    @Enumerated(EnumType.STRING)
    @Column(name = "courier_status")
    @Getter
    @Setter
    private CourierStatus courierStatus;

    public Courier() {
    }
}
