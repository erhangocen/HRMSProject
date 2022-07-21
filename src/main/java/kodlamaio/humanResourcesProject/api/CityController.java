package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.ICityService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/city/")
@CrossOrigin
public class CityController {
    private ICityService _cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this._cityService = cityService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
       return ResponseEntity.ok(_cityService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody City city){
       return ResponseEntity.ok(_cityService.add(city));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody City city){
        return ResponseEntity.ok(_cityService.delete(city));
    }
}
