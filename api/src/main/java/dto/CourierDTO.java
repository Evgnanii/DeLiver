package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierDTO {
    @NotNull
    @Positive
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private Double rating;
    @NotNull
    private String status;

}
