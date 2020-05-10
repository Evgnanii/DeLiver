package com.staging.task.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


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
    @Column(name = "privilege_level",nullable = false)
    private PrivilegeLevel privilegeLevel;

    public Client() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PrivilegeLevel getPrivilegeLevel() {
        return privilegeLevel;
    }

    public void setPrivilegeLevel(PrivilegeLevel privilegeLevel) {
        this.privilegeLevel = privilegeLevel;
    }
}
