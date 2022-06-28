package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IEmployerService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.Employer;
import kodlamaio.humanResourcesProject.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers/")
public class EmployerController {

    private IEmployerService _employerService;

    @Autowired
    public EmployerController(IEmployerService _employerService) {
        this._employerService = _employerService;
    }

    @GetMapping("getall")
    public DataResult<List<Employer>> getAll(){
        return _employerService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody Employer employer){
        return _employerService.add(employer);
    }

    @PostMapping("update")
    public Result update(@RequestBody Employer employer){
        return _employerService.update(employer);
    }
}
