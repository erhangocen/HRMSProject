package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.ICityService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city/")
public class CityController {
    private ICityService _cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this._cityService = cityService;
    }

    @GetMapping("getAll")
    public DataResult<List<City>> getAll(){
       return  _cityService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody City city){
       return _cityService.add(city);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestBody City city){
        return _cityService.delete(city);
    }
}
