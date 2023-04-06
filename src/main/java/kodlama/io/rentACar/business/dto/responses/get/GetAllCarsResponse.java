package kodlama.io.rentACar.business.dto.responses.get;

import kodlama.io.rentACar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {
    private int modelId;
    private int id;
    private int modelYear;
    private String plate;
    private State state;
    private double dailyPrice;
    private String modelName; // Car -> Model.name
    private String brandModelName; // Car -> Model -> Brand.name
}
