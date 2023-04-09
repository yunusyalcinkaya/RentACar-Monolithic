package kodlama.io.rentACar.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRentalsResponse {
    private int id;
    private int carId;
    private double dailyPrice;
    private int rentedForDays;
    private double totalPrice;
    private LocalDateTime startDate;
}
