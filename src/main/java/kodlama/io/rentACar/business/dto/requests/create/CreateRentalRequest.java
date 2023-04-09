package kodlama.io.rentACar.business.dto.requests.create;

import kodlama.io.rentACar.business.dto.requests.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
    private int carId;
    private double dailyPrice;
    private int rentedForDays;
    private PaymentRequest paymentRequest;

}

