package dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ClientDTO {
    private Long clientId;
    private String clientName;
    private String clientEmail;
    private String clientPhoneNumber;
    private String clientAddress;
    private Date dateOfBirth;
    private String privilegeLevel;
}
