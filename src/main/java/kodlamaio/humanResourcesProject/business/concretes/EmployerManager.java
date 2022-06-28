package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IEmployerService;
import kodlamaio.humanResourcesProject.business.abstracts.IUserService;
import kodlamaio.humanResourcesProject.core.utilities.results.*;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IEmailValidationDao;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IEmployerDao;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IUserDao;
import kodlamaio.humanResourcesProject.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerManager extends UserManager implements IEmployerService {

    private IEmployerDao _employerDao;

    @Autowired
    public EmployerManager(IEmployerDao employerDao, IUserDao userDao, IEmailValidationDao emailValidationDao) {
        super(userDao,emailValidationDao);
        this._employerDao = employerDao;
    }

    @Override
    public Result add(Employer employer) {

        List<Result> results = new ArrayList<Result>();
        boolean isFail = false;

        Result nullControl = nullController(employer);
        Result emailControl = checkEmail(employer);
        Result employerEmailControl = checkEmployerEmail(employer);

        results.add(nullControl);
        //results.add(emailControl);
        results.add(employerEmailControl);

        for (var result : results){
            if (result.isSuccess()){
                isFail = true;
                return result;
            }
        }

        if (isFail == false){
            _employerDao.save(employer);
            return new SuccessResult();
        }
        else {
            return new ErrorResult();
        }
    }

    @Override
    public Result update(Employer employer) {
        _employerDao.save(employer);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(_employerDao.findAll());
    }

    @Override
    public Result checkEmployerEmail(Employer employer) {
        String[] domain = employer.getEmail().split("@");
        if (employer.getWebAddress().contains(domain[1])){
            return new SuccessResult();
        }
        return new ErrorResult("The e-mail address must be an extension of the web address.");
    }

    @Override
    public Result nullController(Employer employer) {
        if (
                employer.getCompanyName() == ""
                || employer.getWebAddress() == ""
                || employer.getPhoneNumber() == ""
                || employer.getEmail() == ""
                || employer.getPassword() == "" )
        {
            return new ErrorResult("you must fill in the fields");
        }
        return new SuccessResult();
    }
}
