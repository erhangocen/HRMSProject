package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IEmailValidationService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IEmailValidationDao;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailValidationManager implements IEmailValidationService {

    private IEmailValidationDao _emailValidationDao;

    @Autowired
    public EmailValidationManager(IEmailValidationDao emailValidationDao) {
        this._emailValidationDao = emailValidationDao;
    }

    @Override
    public Result add(EmailValidation emailValidation) {
        _emailValidationDao.save(emailValidation);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<EmailValidation>> getAll() {
        return new SuccessDataResult<List<EmailValidation>>(_emailValidationDao.findAll());
    }
}
