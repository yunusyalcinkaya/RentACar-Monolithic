package kodlama.io.rentACar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // dailyPrice, Car sınıfında da var
    // Kiraya verirlen indirim uygulayavilirim, o yüzden burada da tanımladık
    private double dailyPrice;
    private int rentedForDays;
    private double totalPrice;
    private LocalDateTime startDate;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
}
