package by.st.deliver.core.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;
    @Column(name = "name")
    protected String username;
    @Column(name = "password")
    protected String password;
    private String email;
    @Column(name = "phone_number", nullable = false, unique = true)

    private String phoneNumber;
    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "privilege_level", nullable = false, columnDefinition = "enum('DIAMOND', 'SILVER', 'GOLD')")
    private PrivilegeLevel privilegeLevel;


}
