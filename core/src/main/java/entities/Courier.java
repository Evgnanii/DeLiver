package entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "couriers")
public class Courier {

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


}
