package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;

import java.util.List;

public interface IEmailValidationService {
    Result add(EmailValidation emailValidation);
    DataResult<List<EmailValidation>> getAll();
}
