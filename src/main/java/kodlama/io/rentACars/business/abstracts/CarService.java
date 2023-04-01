package kodlama.io.rentACars.business.abstracts;

import kodlama.io.rentACars.business.dto.requests.create.CreateCarRequest;
import kodlama.io.rentACars.business.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentACars.business.dto.responses.create.CreateCarResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetAllCarsResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetCarResponse;
import kodlama.io.rentACars.business.dto.responses.update.UpdateCarResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    GetCarResponse getById(int id);
    CreateCarResponse add(CreateCarRequest request);
    UpdateCarResponse update(int id, UpdateCarRequest request);
    void delete(int id);
}
