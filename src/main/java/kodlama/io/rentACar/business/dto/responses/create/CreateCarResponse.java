package kodlama.io.rentACar.business.dto.responses.create;

import kodlama.io.rentACar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarResponse {

    private int modelId;
    private int id;
    private int modelYear;
    private String plate;
    private State state;
    private double dailyPrice;
}
