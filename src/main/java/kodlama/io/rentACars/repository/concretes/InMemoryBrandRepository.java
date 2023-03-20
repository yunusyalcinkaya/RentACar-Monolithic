package kodlama.io.rentACars.repository.concretes;

import kodlama.io.rentACars.entities.concretes.Brand;
import kodlama.io.rentACars.repository.abstracts.BrandRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBrandRepository implements BrandRepository {
    private final List<Brand> brands;

    public InMemoryBrandRepository() {
        brands = new ArrayList<>();
        brands.add(new Brand(1,"Mecedes"));
        brands.add(new Brand(2,"BMW"));
        brands.add(new Brand(3,"Audi"));
        brands.add(new Brand(4,"Opel"));
    }

    @Override
    public List<Brand> getAll() {
        System.out.println("------------ head of brand list -------------");
        for (Brand brand : brands) {
            System.out.println(brand);
        }
        System.out.println("------------ end of brand list -------------");
        return brands;
    }

    @Override
    public Brand add(Brand brand) {
        brands.add(brand);
        System.out.println("Brand added: " + brand);
        return brand;
    }

    @Override
    public Brand update(int id, Brand brand) {
        for (Brand b : brands) {
            if (b.getId() == id){
                b.setId(brand.getId());
                b.setName(brand.getName());
                System.out.println("brand "+id + " updated. New brand: " + brand);
            }
        }
        return brand;
    }

    @Override
    public void delete(int id) {
        for (Brand brand : brands) {
            if(brand.getId() == id){
                brands.remove(brand);
                System.out.println("Brand deleted: " + brand);
            }
        }
    }

    @Override
    public Brand getById(int id) {
        for (Brand brand : brands) {
            if (brand.getId() == id) {
                System.out.println("Get product by id: " + brand);
                return brand;
            }
        }
        return null;
    }
}
