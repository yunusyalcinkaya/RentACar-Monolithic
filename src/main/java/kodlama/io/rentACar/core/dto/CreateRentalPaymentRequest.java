package kodlama.io.rentACar.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//hem Rental hemde Payment ortak kullanacağı için buraya oluşturduk
//kiralamanın ücretini ödeme işlemini yaparken kullanılacak
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalPaymentRequest {
        private String cardNumber;
        private String cardHolder;
        private int cardExpirationYear;
        private int cardExpirationMonth;
        private String cardCvv;
        private double price;

}
