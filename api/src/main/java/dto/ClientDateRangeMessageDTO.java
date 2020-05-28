package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDateRangeMessageDTO {
    private Date dateRangeStart;
    private Date dateRangeEnd;
}
