package kodlama.io.rentACars.business.concretes;

import kodlama.io.rentACars.business.abstracts.ModelService;
import kodlama.io.rentACars.business.dto.requests.create.CreateModelRequest;
import kodlama.io.rentACars.business.dto.requests.update.UpdateModelRequest;
import kodlama.io.rentACars.business.dto.responses.create.CreateModelResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetAllModelsResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetModelResponse;
import kodlama.io.rentACars.business.dto.responses.update.UpdateModelResponse;
import kodlama.io.rentACars.entities.Model;
import kodlama.io.rentACars.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = repository.findAll();
        List<GetAllModelsResponse> response = models
                .stream()
                .map(model -> mapper.map(model,GetAllModelsResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetModelResponse getById(int id) {
        checkIdModelExistsById(id);
        Model model = repository.findById(id).orElseThrow();
        GetModelResponse response = mapper.map(model,GetModelResponse.class);

        return response;
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        Model model = mapper.map(request,Model.class);
        model.setId(0); // bunu eklemezsek brandId ile karışır
        repository.save(model);
        CreateModelResponse response = mapper.map(model,CreateModelResponse.class);
        return response;
    }

    @Override
    public UpdateModelResponse update(int id, UpdateModelRequest request) {
        checkIdModelExistsById(id);
        Model model = mapper.map(request,Model.class);
        model.setId(id);
        repository.save(model);
        UpdateModelResponse response = mapper.map(model,UpdateModelResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    // Diğer kuralları da yaz
    private void checkIdModelExistsById(int id){
        if(!repository.existsById(id)){
            throw new RuntimeException("bu id'de bir model mevcut değil");
        }
    }
    private void checkIdModelExistsByName(String name){
        if(!repository.existsByNameIgnoreCase(name)){
            throw new RuntimeException("bu isimde bir model mevcut değil");
        }
    }
}
