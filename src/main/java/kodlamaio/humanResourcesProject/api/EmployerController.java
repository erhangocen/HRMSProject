package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IEmployerService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.ErrorDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.Employer;
import kodlamaio.humanResourcesProject.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employers/")
public class EmployerController {

    private IEmployerService _employerService;

    @Autowired
    public EmployerController(IEmployerService _employerService) {
        this._employerService = _employerService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_employerService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody Employer employer){
        return ResponseEntity.ok(_employerService.add(employer));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Validation errors");
        return errors;
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody Employer employer){
        return ResponseEntity.ok(_employerService.update(employer));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody Employer employer){
        return ResponseEntity.ok(_employerService.delete(employer));
    }

}
