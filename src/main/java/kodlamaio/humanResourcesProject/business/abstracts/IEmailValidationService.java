package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.City;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;

import java.util.List;

public interface IEmailValidationService {
    Result add(EmailValidation emailValidation);
    Result delete(EmailValidation emailValidation);
    DataResult<List<EmailValidation>> getAll();
}
