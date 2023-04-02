package kodlama.io.rentACars.business.abstracts;

import kodlama.io.rentACars.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentACars.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentACars.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetAllMaintenancesResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetMaintenanceResponse;
import kodlama.io.rentACars.business.dto.responses.update.UpdateMaintenanceResponse;
import kodlama.io.rentACars.entities.Maintenance;

import java.util.List;

public interface MaintenanceService {
    List<GetAllMaintenancesResponse> getAll();
    GetMaintenanceResponse getById(int id);
    CreateMaintenanceResponse add(CreateMaintenanceRequest request);
    UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request);
    void delete(int id);
}
