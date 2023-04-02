package kodlama.io.rentACars.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMaintenanceResponse {
    private int id;
    private String description;
    private int carId;
}
