package kodlama.io.rentACars.repository;

import kodlama.io.rentACars.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer> {
}
