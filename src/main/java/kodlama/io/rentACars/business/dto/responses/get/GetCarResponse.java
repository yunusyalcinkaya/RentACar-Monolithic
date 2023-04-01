package kodlama.io.rentACars.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
    private int id;
    private int modelId;
    private int modelYear;
    private String plate;
    private int state; // 1- available, 2- rented, 3 - maintance
    private double dailyPrice;
}
