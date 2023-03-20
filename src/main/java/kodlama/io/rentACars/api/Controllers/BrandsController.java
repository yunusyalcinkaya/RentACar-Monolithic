package kodlama.io.rentACars.api.Controllers;

import kodlama.io.rentACars.business.abstracts.BrandService;
import kodlama.io.rentACars.entities.concretes.Brand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")// localhost:8080/brands
public class BrandsController {

    private final BrandService service;


    public BrandsController(BrandService service) {
        this.service = service;
    }

    @GetMapping("/getAll")//localhost:8080/brands/getAll
    public List<Brand> findAll(){
        return service.getAll();

    }

    @PutMapping("/update/{id}")
    public Brand update(@PathVariable int id, @RequestBody Brand brand){
        return service.update(id,brand);
    }

    @PutMapping("/add")
    public Brand add(@RequestBody Brand brand){
        return service.add(brand);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable int id){
        return service.getById(id);
    }
}
