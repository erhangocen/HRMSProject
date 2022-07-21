package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IStaffValidationService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.StaffValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/staffValidations/")
@CrossOrigin
public class StaffValidationController {

    private IStaffValidationService _staffValidationService;

    @Autowired
    public StaffValidationController(IStaffValidationService _staffValidationService) {
        this._staffValidationService = _staffValidationService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_staffValidationService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody StaffValidation staffValidation){
        return ResponseEntity.ok(_staffValidationService.add(staffValidation));
    }

    @PostMapping("validate")
    public ResponseEntity<?> validate(@RequestParam int employerId,@RequestParam int systemUserId){
        return ResponseEntity.ok(_staffValidationService.validate(employerId,systemUserId));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(StaffValidation staffValidation){
        return ResponseEntity.ok(_staffValidationService.delete(staffValidation));
    }
}
