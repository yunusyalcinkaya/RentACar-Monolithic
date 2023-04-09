package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.abstracts.MaintenanceService;
import kodlama.io.rentACar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentACar.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentACar.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentACar.business.dto.responses.get.GetAllMaintenancesResponse;
import kodlama.io.rentACar.business.dto.responses.get.GetMaintenanceResponse;
import kodlama.io.rentACar.business.dto.responses.update.UpdateMaintenanceResponse;
import kodlama.io.rentACar.entities.Maintenance;
import kodlama.io.rentACar.entities.enums.State;
import kodlama.io.rentACar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {

    private final MaintenanceRepository repository;
    private final ModelMapper mapper;
    CarService carService;


    @Override
    public List<GetAllMaintenancesResponse> getAll() {
        List<Maintenance> maintenances = repository.findAll();
        List<GetAllMaintenancesResponse> response =maintenances.stream()
                .map(maintenance -> mapper.map(maintenance, GetAllMaintenancesResponse.class)).toList();
        return response;
    }

    @Override
    public GetMaintenanceResponse getById(int id) {
        checkIfMaintenanceExistsById(id);
        Maintenance maintenance = repository.findById(id).orElseThrow();
        GetMaintenanceResponse response = mapper.map(maintenance,GetMaintenanceResponse.class);
        return  response;
    }

    @Override
    public GetMaintenanceResponse returnCarFromMaintenance(int carId) {
        checkIfCarIsNotUnderMaintenance(carId);
        Maintenance maintenance = repository.findByCarIdAndIsCompletedIsFalse(carId);
        maintenance.setCompleted(true);
        maintenance.setEndDate(LocalDateTime.now());
        repository.save(maintenance); // Update
        carService.changeState(carId, State.AVAILABLE);
        GetMaintenanceResponse response = mapper.map(maintenance, GetMaintenanceResponse.class);

        return response;
    }

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        checkIfCarUnderMaintenance(request);
        checkCarAvailabilityForMaintenance(request);
        Maintenance maintenance = mapper.map(request, Maintenance.class);
        maintenance.setId(0);
        maintenance.setCompleted(false);
        maintenance.setStartDate(LocalDateTime.now());
        maintenance.setEndDate(null);
        repository.save(maintenance);
        carService.changeState(request.getCarId(), State.MAINTENANCE);
        CreateMaintenanceResponse response = mapper.map(maintenance, CreateMaintenanceResponse.class);

        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request) {
        checkIfMaintenanceExistsById(id);
        Maintenance maintenance = mapper.map(request, Maintenance.class);
        maintenance.setId(id);
        repository.save(maintenance);
        UpdateMaintenanceResponse response = mapper.map(maintenance, UpdateMaintenanceResponse.class);

        return response;
    }

    @Override
    public void deleteById(int id) {
        checkIfMaintenanceExistsById(id);
        makeCarAvailableIfIsCompletedFalse(id);
        repository.deleteById(id);
    }
// eğer mevcut bakımdaki Car için Maintenance silinirse state= Available yap
    // geçmiş kayıtlardan bir Maintenance silinirse birşey yapma
    private void makeCarAvailableIfIsCompletedFalse(int id){
        checkIfMaintenanceExistsById(id);
        int carId = repository.findById(id).get().getCar().getId();
        if (repository.existsByCarIdAndIsCompletedIsFalse(carId))
            carService.changeState(carId,State.AVAILABLE);
    }

    private void checkIfMaintenanceExistsById(int id){
        if(!repository.existsById(id))
            throw new RuntimeException("Maintenance does not exists with id: " + id);
    }

    private void checkIfCarIsNotUnderMaintenance(int carId) {
        if (!repository.existsByCarIdAndIsCompletedIsFalse(carId)) {
            throw new RuntimeException("Car does not exists in maintenance. carId:" + carId);
        }
    }

    private void checkIfCarUnderMaintenance(CreateMaintenanceRequest request) {
        if (repository.existsByCarIdAndIsCompletedIsFalse(request.getCarId())) {
            throw new RuntimeException("Car is already in car. carId:" + request.getCarId());
        }
    }

    private void checkCarAvailabilityForMaintenance(CreateMaintenanceRequest request) {
        if (carService.getById(request.getCarId()).getState().equals(State.RENTED)) {
            throw new RuntimeException("Car can not be taken into maintenance. Because car is rented. carId:"
                    + request.getCarId());
        }
    }

}
