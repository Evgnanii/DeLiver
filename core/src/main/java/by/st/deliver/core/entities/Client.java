package by.st.deliver.core.entities;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
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

    public PrivilegeLevel getPrivilegeLevel() {
        return privilegeLevel;
    }

    public void setPrivilegeLevel(PrivilegeLevel privilegeLevel) {
        this.privilegeLevel = privilegeLevel;
    }

    public Client() {
    }

    public Client(Long clientId, String clientName, String clientEmail, String clientPhoneNumber, String clientAddress, Date dateOfBirth, @NotNull PrivilegeLevel privilegeLevel) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientAddress = clientAddress;
        this.dateOfBirth = dateOfBirth;
        this.privilegeLevel = privilegeLevel;
    }
}
