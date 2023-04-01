package kodlama.io.rentACars.business.abstracts;

import kodlama.io.rentACars.business.dto.requests.create.CreateModelRequest;
import kodlama.io.rentACars.business.dto.requests.update.UpdateModelRequest;
import kodlama.io.rentACars.business.dto.responses.create.CreateModelResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetAllModelsResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetModelResponse;
import kodlama.io.rentACars.business.dto.responses.update.UpdateModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    GetModelResponse getById(int id);
    CreateModelResponse add(CreateModelRequest request);
    UpdateModelResponse update(int id,UpdateModelRequest request);
    void delete(int id);
}
