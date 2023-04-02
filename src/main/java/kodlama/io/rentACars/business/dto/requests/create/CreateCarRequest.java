package kodlama.io.rentACars.business.dto.requests.create;

import kodlama.io.rentACars.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    private int modelId;
    private int modelYear;
    private String plate;
    private State state;
    private double dailyPrice;
}
