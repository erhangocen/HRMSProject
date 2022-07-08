package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IEmailValidationService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emailValidation/")
public class EmailValidationController {

    private IEmailValidationService _emailValidationService;

    @Autowired
    public EmailValidationController(IEmailValidationService emailValidationService) {
        this._emailValidationService = emailValidationService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody EmailValidation emailValidation){
        return ResponseEntity.ok(_emailValidationService.add(emailValidation));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody EmailValidation emailValidation){
        return ResponseEntity.ok(_emailValidationService.delete(emailValidation));
    }

    @PostMapping("validate")
    public ResponseEntity<?> validate(@RequestParam int emailValidationId){
        return ResponseEntity.ok(_emailValidationService.validate(emailValidationId));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_emailValidationService.getAll());
    }
}
