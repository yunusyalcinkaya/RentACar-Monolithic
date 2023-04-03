package kodlama.io.rentACar.repository;

import kodlama.io.rentACar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
    boolean existsByNameIgnoreCase(String name);
}
