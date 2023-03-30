package kodlama.io.rentACars.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// her markanın 1 veya daha fazla modeli olabilir
//bu anotasyonlar "lombok" eklentisi sayesinde kullanılıyo
@Entity
@AllArgsConstructor // bizim yerimize full parametreli constructor oluşturur
@NoArgsConstructor // parametresiz constructor oluşturur
@Getter
@Setter // bunların hepsi lombok sayesinde yapılıyor
@Table(name = "brands") // postgresql de snake_case yazılır
public class Brand { //marka

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id'yi biz elle versek de etki etmez, oto oluşur
    @Column(name = "id") // -> sütunları bu şekilde istediğimiz isimde tablolarda tutabiliriz. yazmasak da default olarak değişken isminde tutar
    private int id;
    private String name;// isimlendirmeleri brandname, brandId gibi yapma!!!

    @OneToMany(mappedBy = "brand") // foreach gibi düşün, herbir modeli brand ile eşleştiriyor
    private List<Model> models;
}
