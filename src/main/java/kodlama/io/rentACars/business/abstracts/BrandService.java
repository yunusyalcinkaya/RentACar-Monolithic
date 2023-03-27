package kodlama.io.rentACars.business.abstracts;

import kodlama.io.rentACars.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentACars.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetBrandResponse;
import kodlama.io.rentACars.entities.Brand;

import java.util.List;

public interface BrandService {
// CRUD
    List<GetAllBrandsResponse> getAll();
    GetBrandResponse getById(int id);
    CreateBrandResponse add(CreateBrandRequest request);
    Brand update(int id, Brand brand);
    void delete(int id);

}
