package kodlama.io.rentACar.api.controllers;

import kodlama.io.rentACar.business.abstracts.MaintenanceService;
import kodlama.io.rentACar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentACar.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentACar.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentACar.business.dto.responses.get.GetAllMaintenancesResponse;
import kodlama.io.rentACar.business.dto.responses.get.GetMaintenanceResponse;
import kodlama.io.rentACar.business.dto.responses.update.UpdateMaintenanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@AllArgsConstructor
public class MaintenancesController {

    private final MaintenanceService service;

    @GetMapping
    public List<GetAllMaintenancesResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetMaintenanceResponse getById(int id){
        return service.getById(id);
    }

    @PutMapping("/return/{carId}")
    public GetMaintenanceResponse returnCarFromMaintenance(@PathVariable int carId) {
        return service.returnCarFromMaintenance(carId);
    }

    @PostMapping
    public CreateMaintenanceResponse add(@RequestBody CreateMaintenanceRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateMaintenanceResponse update(@PathVariable int id, @RequestBody UpdateMaintenanceRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        service.delete(id);
    }
}
