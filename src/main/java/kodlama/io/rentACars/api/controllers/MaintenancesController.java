package kodlama.io.rentACars.api.controllers;

import kodlama.io.rentACars.business.abstracts.MaintenanceService;
import kodlama.io.rentACars.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentACars.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentACars.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetAllMaintenancesResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetMaintenanceResponse;
import kodlama.io.rentACars.business.dto.responses.update.UpdateMaintenanceResponse;
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
