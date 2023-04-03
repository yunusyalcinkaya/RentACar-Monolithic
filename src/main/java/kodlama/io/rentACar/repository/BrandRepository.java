package kodlama.io.rentACar.repository;

import kodlama.io.rentACar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

//repository = dataAccess = dao
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    // JPARepo -> crud metodlarını içeriyor. Jpa kullanmasaydık entity nesneleri üzerindeki crud işlemlerinii
    // kendimiz yazacaktık. (add(),update(),list(),delete() gibi metodları)
    // Custom queries yazacağız

    // arka planda bu metod'un body'si var
    boolean existsBooleanByNameIgnoreCase(String name);

}
