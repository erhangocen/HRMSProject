package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IEmailValidationService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emailvalidaion/")
public class EmailValidationController {

    private IEmailValidationService _emailValidationService;

    @Autowired
    public EmailValidationController(IEmailValidationService emailValidationService) {
        this._emailValidationService = emailValidationService;
    }


    @GetMapping("getall")
    public DataResult<List<EmailValidation>> getAll(){
        return _emailValidationService.getAll();
    }
}