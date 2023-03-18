package kodlama.io.rentACars.api.Controllers;

import kodlama.io.rentACars.business.abstracts.BrandService;
import kodlama.io.rentACars.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands")// localhost:8080/brands
public class BrandsController {

    private BrandService service;


    public BrandsController(BrandService service) {
        this.service = service;
    }

    @GetMapping("/getAll")//localhost:8080/brands/getAll
    public List<Brand> findAll(){
        return service.getAll();

    }
}
