package kodlama.io.rentACars.repository;

import kodlama.io.rentACars.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
   // boolean existsByNameIgnoreCase(String name);
}
