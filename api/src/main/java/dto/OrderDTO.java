package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long orderId;

    private Long courierId;

    private Long clientId;

    private Long restaurantId;

    private Double totalCost;

    private String orderStatus;

}
