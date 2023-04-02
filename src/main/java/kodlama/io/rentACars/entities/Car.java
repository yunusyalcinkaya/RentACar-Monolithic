package kodlama.io.rentACars.entities;

import jakarta.persistence.*;
import kodlama.io.rentACars.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int modelYear;
    private String plate;
    private double dailyPrice;

    @Enumerated(EnumType.STRING)
    private State state;

    @OneToOne(mappedBy = "car")
    private Maintenance maintenance;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
