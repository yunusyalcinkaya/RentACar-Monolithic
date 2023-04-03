package kodlama.io.rentACar.business.dto.requests.update;

import kodlama.io.rentACar.entities.enums.State;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    private int modelId;
    private int modelYear;
    private String plate;
    private State state;
    private double dailyPrice;
}
