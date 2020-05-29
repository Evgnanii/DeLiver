package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long clientId;
    private String clientName;
    private String clientEmail;
    private String clientPhoneNumber;
    private String clientAddress;
    private Date dateOfBirth;
    private String privilegeLevel;
}
