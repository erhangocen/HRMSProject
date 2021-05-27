package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IStaffValidationService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.StaffValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staffvalidations/")
public class StaffValidationController {

    private IStaffValidationService _staffValidationService;

    @Autowired
    public StaffValidationController(IStaffValidationService _staffValidationService) {
        this._staffValidationService = _staffValidationService;
    }

    @GetMapping("getall")
    public DataResult<List<StaffValidation>> getAll(){
        return _staffValidationService.getAll();
    }

    @PostMapping("add")
    public Result add(StaffValidation staffValidation){
        return _staffValidationService.add(staffValidation);
    }
}
