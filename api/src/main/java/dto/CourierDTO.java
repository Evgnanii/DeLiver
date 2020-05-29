package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierDTO {

    private Long courierId;

    private String courierFirstName;

    private String courierSecondName;

    private Double courierRating;

    private String courierStatus;

}
