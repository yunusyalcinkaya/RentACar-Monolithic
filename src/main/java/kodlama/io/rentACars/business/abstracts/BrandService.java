package kodlama.io.rentACars.business.abstracts;

import kodlama.io.rentACars.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAll();
}
