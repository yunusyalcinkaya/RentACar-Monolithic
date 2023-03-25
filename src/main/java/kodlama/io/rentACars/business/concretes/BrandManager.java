package kodlama.io.rentACars.business.concretes;

import kodlama.io.rentACars.business.abstracts.BrandService;
import kodlama.io.rentACars.entities.Brand;
import kodlama.io.rentACars.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager  implements BrandService {
    private final BrandRepository repository;

    @Override
    public List<Brand> getAll() {
        return repository.findAll();// findAll() -> List<> döner
    }

    @Override
    public Brand getById(int id) {
       checkIfBrandExists(id);
        return repository.findById(id).orElseThrow(); //findById null dönerse exception fırlat
    }

    @Override
    public Brand add(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public Brand update(int id, Brand brand) {
        checkIfBrandExists(id);
        brand.setId(id);
        return repository.save(brand);
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
}
