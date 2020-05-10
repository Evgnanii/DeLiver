package com.staging.task.entities;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "couriers")
public class Courier {

    public Courier(String courierFirstName, String courierSecondName, Double courierRating, CourierStatus courierStatus) {
        this.courierFirstName = courierFirstName;
        this.courierSecondName = courierSecondName;
        this.courierRating = courierRating;
        this.courierStatus = courierStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courier_id")
    private Long courierId;
    @Column(name = "courier_first_name")
    private String courierFirstName;
    @Column(name = "courier_second_name")
    private String courierSecondName;
    @Column(name = "courier_rating")
    private Double courierRating;
    @Enumerated(EnumType.STRING)
    @Column(name = "courier_status")
    private CourierStatus courierStatus;

    public Courier() {
    }
}
