package kodlama.io.rentACars.repository.abstracts;

import kodlama.io.rentACars.entities.concretes.Brand;

import java.util.List;

public interface BrandRepository {
    List<Brand> getAll(); // list of brand
    Brand getById(int id);
    Brand add(Brand brand);
    Brand update(int id, Brand brand);
    void delete(int id);
}
