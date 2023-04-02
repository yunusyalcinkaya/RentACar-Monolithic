package kodlama.io.rentACars.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaintenanceResponse {
    private int id;
    private String description;
    private int carId;
}
