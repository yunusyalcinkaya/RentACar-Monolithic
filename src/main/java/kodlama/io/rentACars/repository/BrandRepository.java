package kodlama.io.rentACars.repository;

import kodlama.io.rentACars.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand,Integer> {
    // JPARepo -> crud metodlarını içeriyor
    // Cusrom queries yazacağız

}
