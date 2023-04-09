package kodlama.io.rentACar.repository;

import kodlama.io.rentACar.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
}
