package kodlama.io.rentACars.business.concretes;

import kodlama.io.rentACars.business.abstracts.BrandService;
import kodlama.io.rentACars.entities.concretes.Brand;
import kodlama.io.rentACars.repository.abstracts.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager  implements BrandService {

    private final BrandRepository repository;

    public BrandManager(BrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Brand> getAll() {
        // burada iş kuralları olacak
        return repository.getAll();
    }

    @Override
    public Brand add(Brand brand) {
        return repository.add(brand);
    }

    @Override
    public Brand update(int id, Brand brand) {
        return repository.update(id,brand);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Brand getById(int id) {
        return repository.getById(id);
    }
}
