package by.st.deliver.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "couriers")
public class Courier  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;
    @Column(name = "name")
    protected String username;
    @Column(name = "password")
    protected String password;

    @Column(name = "courier_rating")
    private Double rating;

    @Enumerated(EnumType.STRING)
    @Column(name = "courier_status")
    private CourierStatus status;

}
