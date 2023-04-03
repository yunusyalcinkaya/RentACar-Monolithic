package kodlama.io.rentACar.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMaintenanceResponse {
    private int id;
    private String information;
    private int carId;
    private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
