package kodlama.io.rentACar.repository;

import kodlama.io.rentACar.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer> {
    //Car nesnesinin id alanına göre, isCompleted değeri false olanları getirir
    // Bir arabanın Maintenance tablosunda birden çok kaydı olabilir
    // ama bir bakım tamamlanıp diğerine girebilir
    // yani isCompleted değeri false olan 1 adet kayıt olabilir
    // diğer kayıtlar isComplete değeri 0 olan eski kayıtlardır
    Maintenance findByCarIdAndIsCompletedIsFalse(int carId);

    //Car nesnesinin id alanına göre, isCompleted değeri false olan varsa
    // yani id si verilen araba şuan bakımda ise true döner
    boolean existsByCarIdAndIsCompletedIsFalse(int carId);
}
