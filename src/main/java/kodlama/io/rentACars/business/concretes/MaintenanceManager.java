package kodlama.io.rentACars.business.concretes;

import kodlama.io.rentACars.business.abstracts.MaintenanceService;
import kodlama.io.rentACars.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentACars.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentACars.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetAllMaintenancesResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetMaintenanceResponse;
import kodlama.io.rentACars.business.dto.responses.update.UpdateMaintenanceResponse;
import kodlama.io.rentACars.entities.Car;
import kodlama.io.rentACars.entities.Maintenance;
import kodlama.io.rentACars.entities.enums.State;
import kodlama.io.rentACars.repository.CarRepository;
import kodlama.io.rentACars.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {

    private final MaintenanceRepository repository;
    private final ModelMapper mapper;
    CarRepository carRepository;

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
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        checkCarState(request.getCarId());
        Maintenance maintenance = mapper.map(request,Maintenance.class);
        maintenance.setId(0);
        Maintenance createdMaintenance = repository.save(maintenance);
        Car car = carRepository.findById(createdMaintenance.getCar().getId()).orElseThrow();
        System.out.println("--------------" + car.getId()+", "+car.getMaintenance());
        car.setState(State.MAINTENANCE);
        System.out.println("--------------" + car.getId()+", "+car.getMaintenance());
        System.out.println("--------------" + createdMaintenance.getCar().getMaintenance()+", "+createdMaintenance.getCar().getMaintenance());

        CreateMaintenanceResponse response = mapper.map(createdMaintenance, CreateMaintenanceResponse.class);
        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request) {
        checkIfMaintenanceExistsById(id);
        Maintenance maintenance = mapper.map(request,Maintenance.class);
        maintenance.setId(id);
        Maintenance createdMaintenance = repository.save(maintenance);
        UpdateMaintenanceResponse response = mapper.map(createdMaintenance,UpdateMaintenanceResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        checkIfMaintenanceExistsById(id);
        Maintenance maintenance = repository.findById(id).orElseThrow();
        Car car = carRepository.findById(maintenance.getCar().getId()).orElseThrow();
        car.setState(State.AVAILABLE);
        repository.deleteById(id);
    }

    private void checkIfMaintenanceExistsById(int id){
        if(!repository.existsById(id))
            throw new RuntimeException("Maintenance does not exists with id: " + id);
    }

    private  void checkCarState(int id){
        Car car = carRepository.findById(id).orElseThrow();
        if (car.getState() == State.MAINTENANCE)
            throw new RuntimeException("Car is alreadey in maintenance. carId: " + car.getId());
        if (car.getState() == State.RENTED)
            throw new RuntimeException("Car is RENTED. carId: " + car.getId());
    }

}
