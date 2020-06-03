package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    @Positive
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String address;
    @Past
    @NotNull
    private Date dateOfBirth;
    @NotNull
    private String privilegeLevel;
}
