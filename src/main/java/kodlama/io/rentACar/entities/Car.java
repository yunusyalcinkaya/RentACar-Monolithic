package kodlama.io.rentACar.entities;

import jakarta.persistence.*;
import kodlama.io.rentACar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenances;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
