package kodlama.io.rentACars.repository;

import kodlama.io.rentACars.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
    boolean existsByNameIgnoreCase(String name);
}
