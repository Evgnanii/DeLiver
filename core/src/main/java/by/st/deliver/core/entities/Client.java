package by.st.deliver.core.entities;


import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")

    private Long clientId;
    @Column(name = "client_name", nullable = false, unique = true)

    private String clientName;
    @Column(name = "client_email", nullable = false, unique = true)

    private String clientEmail;
    @Column(name = "client_phone_number", nullable = false, unique = true)

    private String clientPhoneNumber;
    @Column(name = "client_address", nullable = false, unique = true)
    private String clientAddress;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "privilege_level", nullable = false)
    private PrivilegeLevel privilegeLevel;


}
