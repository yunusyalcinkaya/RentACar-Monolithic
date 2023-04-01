package kodlama.io.rentACars.business.concretes;

import kodlama.io.rentACars.business.abstracts.BrandService;
import kodlama.io.rentACars.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentACars.business.dto.requests.update.UpdateBrandRequest;
import kodlama.io.rentACars.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetBrandResponse;
import kodlama.io.rentACars.business.dto.responses.update.UpdateBrandResponse;
import kodlama.io.rentACars.entities.Brand;
import kodlama.io.rentACars.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager  implements BrandService {
    private final BrandRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = repository.findAll();
        List<GetAllBrandsResponse> response =
                brands.stream().map(brand -> mapper.map(brand, GetAllBrandsResponse.class)).toList();
        //toList teker teker aldığı brandleri bir listeye dönüştürür, liste dönmemiz lazım
        //stream kullanmamızın amacı bir listenin içinde dolanmamız lazım
        return response;
    }

    @Override
    public GetBrandResponse getById(int id) {
       checkIfBrandExists(id);
       Brand brand = repository.findById(id).orElseThrow();
       GetBrandResponse response = mapper.map(brand,GetBrandResponse.class);

       return response;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {
        Brand brand = mapper.map(request,Brand.class);
        brand.setId(0); // update olmaması için olabilir, CreateBrandResponse içinde id kısmı varsa karışmaması için, id sıfır versek de yeni oluşturuyor
        // id veritababında var ise update işlemi yapıyor, yoksa add işlemi yapıyor, bu yüzde sıfır verdik
        checkIfBrandExistsByName(request.getName());
        repository.save(brand);
        CreateBrandResponse response = mapper.map(brand,CreateBrandResponse.class);
        return response;

    }

    @Override
    public UpdateBrandResponse update(int id, UpdateBrandRequest request) {
        checkIfBrandExists(id);
        Brand brand = mapper.map(request,Brand.class);
        brand.setId(id);
        repository.save(brand);
        UpdateBrandResponse response = mapper.map(brand,UpdateBrandResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        checkIfBrandExists(id);
        repository.deleteById(id);
    }

    //business rules
    private void checkIfBrandExists(int id){
        if(!repository.existsById(id)) throw new RuntimeException("böyle bir marka mevcut değildir");
    }
    private void checkIfBrandExistsByName(String name){
        if(repository.existsBooleanByNameIgnoreCase(name)){
            throw new RuntimeException("Böyle bir marka sistemde kayıtlı!");
        }
    }
}
