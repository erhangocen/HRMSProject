package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.City;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import kodlamaio.humanResourcesProject.entities.concretes.Employer;

import java.util.List;

public interface IEmailValidationService {
    Result add(EmailValidation emailValidation);
    Result delete(EmailValidation emailValidation);
    Result validate(int userId);
    DataResult<List<EmailValidation>> getAll();
    DataResult<EmailValidation> getByUserId(int id);
}
