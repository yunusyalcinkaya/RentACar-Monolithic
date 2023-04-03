package kodlama.io.rentACar.repository;

import kodlama.io.rentACar.entities.Car;
import kodlama.io.rentACar.entities.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    // Name alanına göre filtreleme yapar
    // Name alanı, parametre olarak gelen ala ise getirir
   // boolean existsByNameIgnoreCase(String name);

    // State alanına göre filtreleme yapar.
    // State alanı, parametre olarak gelen State olmayanları getirir
    List<Car> findAllByStateIsNot(State state);
}
