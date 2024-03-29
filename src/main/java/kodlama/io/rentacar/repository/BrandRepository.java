package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

// CRUD operations
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    // Custom queries
    boolean existsByNameIgnoreCase(String name);

}
