package kodlama.io.rentACar.business.dto.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest { // Base/Super class
    @NotBlank(message = "The card number field cannot be empty")
    @Length(min = 16, max = 16, message = "The card number must consist of 16 numbers")
    private String cardNumber; // 16 haneli

    @NotBlank(message = "The card holder field cannot be empty")
    @Length(min = 5, message = "Cardholder information must consist of at least 5 characters.")
    private String cardHolder;

    @NotNull(message = "The card expiration date field cannot be empty")
    @Min(value = 2023, message = "The card expiration date is invalid")
    private int cardExpirationYear; // minimum 2023

    @NotNull
    @Max(value = 12)
    @Min(value = 1)
    private int cardExpirationMonth; // 1 ile 12

    @NotBlank
    @Length(min = 3, max = 3)
    private String cardCvv; // 3 haneli olmalı
}
