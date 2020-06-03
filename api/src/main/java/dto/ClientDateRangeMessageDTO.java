package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDateRangeMessageDTO {

    @PastOrPresent
    @NotNull(message = "You must declare dates")
    private Date dateRangeStart;

    @PastOrPresent
    @NotNull(message = "You must declare dates")
    private Date dateRangeEnd;
}
