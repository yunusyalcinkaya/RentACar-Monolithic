package kodlama.io.rentACars.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMaintenanceResponse {
    private int id;
    private String description;
    private int carId;
}
