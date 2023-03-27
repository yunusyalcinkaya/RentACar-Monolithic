package kodlama.io.rentACars.api.Controllers;

import kodlama.io.rentACars.business.abstracts.BrandService;
import kodlama.io.rentACars.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentACars.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.rentACars.business.dto.responses.get.GetBrandResponse;
import kodlama.io.rentACars.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")// localhost:8080/api/brands
@AllArgsConstructor
public class BrandsController {

    private final BrandService service;

    // parametre olarak benden veritabanı nesnesi isteyenler request(requests içine paket olarak oluştur)
    // bana veritabanı nesnesi dönenler response(responses paketi içine oluştur), void olmadığı sürece response dönülür

    @GetMapping
    public List<GetAllBrandsResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return service.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse add(@RequestBody CreateBrandRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public Brand update(@PathVariable int id, @RequestBody Brand brand){
        return service.update(id,brand);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
