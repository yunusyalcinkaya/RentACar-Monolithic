package kodlama.io.rentACars.entities;

import jakarta.persistence.*;
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
@Table(name = "models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne // bir modelin bir markası olabilir, bir markanın birden çok modeli olabilir
    @JoinColumn(name = "brand_id") // foreign key
    private Brand brand; // aynı isim mappedBy da kullanılır

    @OneToMany(mappedBy = "model")
    private List<Car> cars;
}
