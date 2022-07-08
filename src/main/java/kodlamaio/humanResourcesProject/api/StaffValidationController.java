package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IStaffValidationService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.StaffValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staffvalidations/")
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
    public ResponseEntity<?> add(StaffValidation staffValidation){
        return ResponseEntity.ok(_staffValidationService.add(staffValidation));
    }

    @PostMapping("validate")
    public ResponseEntity<?> validate(@RequestParam int staffValidationId,@RequestParam int systemUserId){
        return ResponseEntity.ok(_staffValidationService.validate(staffValidationId,systemUserId));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(StaffValidation staffValidation){
        return ResponseEntity.ok(_staffValidationService.delete(staffValidation));
    }
}
