package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import kodlamaio.humanResourcesProject.entities.concretes.User;

import java.util.List;

public interface IUserService {

    DataResult<User> getByUserId(int id);
    DataResult<List<User>> getAllUser();

    Result checkEmail(User user);
    Result validate(EmailValidation emailValidation);
    Result delete(User user);
}
