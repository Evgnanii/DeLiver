package com.staging.task.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "couriers")
public class Courier {


    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }

    public String getCourierFirstName() {
        return courierFirstName;
    }

    public void setCourierFirstName(String courierFirstName) {
        this.courierFirstName = courierFirstName;
    }

    public String getCourierSecondName() {
        return courierSecondName;
    }

    public void setCourierSecondName(String courierSecondName) {
        this.courierSecondName = courierSecondName;
    }

    public Double getCourierRating() {
        return courierRating;
    }

    public void setCourierRating(Double courierRating) {
        this.courierRating = courierRating;
    }

    public CourierStatus getCourierStatus() {
        return courierStatus;
    }

    public void setCourierStatus(CourierStatus courierStatus) {
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
