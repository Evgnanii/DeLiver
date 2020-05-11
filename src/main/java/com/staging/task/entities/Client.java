package com.staging.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    @Getter
    @Setter
    private Long clientId;
    @Column(name = "client_name", nullable = false, unique = true)
    @Getter
    @Setter
    private String clientName;
    @Column(name = "client_email", nullable = false, unique = true)
    @Getter
    @Setter
    private String clientEmail;
    @Column(name = "client_phone_number", nullable = false, unique = true)
    @Getter
    @Setter
    private String clientPhoneNumber;
    @Column(name = "client_address", nullable = false, unique = true)
    @Getter
    @Setter
    private String clientAddress;
    @Column(name = "date_of_birth")
    @Getter
    @Setter
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "privilege_level", nullable = false)
    @Getter
    @Setter
    private PrivilegeLevel privilegeLevel;

    public Client() {
    }

}
