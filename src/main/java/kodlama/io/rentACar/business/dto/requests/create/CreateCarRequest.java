package kodlama.io.rentACar.business.dto.requests.create;

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
    private double dailyPrice;
}