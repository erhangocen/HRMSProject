package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IEmailValidationService;
import kodlamaio.humanResourcesProject.business.abstracts.IEmployerService;
import kodlamaio.humanResourcesProject.business.abstracts.IStaffValidationService;
import kodlamaio.humanResourcesProject.business.abstracts.IUserService;
import kodlamaio.humanResourcesProject.core.utilities.results.*;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IEmployerDao;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import kodlamaio.humanResourcesProject.entities.concretes.Employer;
import kodlamaio.humanResourcesProject.entities.concretes.StaffValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerManager implements IEmployerService {

    private IEmployerDao _employerDao;
    private IUserService _userService;
    private IStaffValidationService _staffValidationService;
    private IEmailValidationService _emailValidationService;

    @Autowired
    public EmployerManager(IEmployerDao employerDao, IUserService userService, IStaffValidationService staffValidationService, IEmailValidationService emailValidationService) {
        super();
        this._employerDao = employerDao;
        this._userService = userService;
        this._staffValidationService = staffValidationService;
        this._emailValidationService = emailValidationService;
    }

    @Override
    public Result add(Employer employer) {

        List<Result> results = new ArrayList<Result>();
        boolean isFail = false;

        Result nullControl = nullController(employer);
        Result emailControl = _userService.checkEmail(employer);
        Result employerEmailControl = checkEmployerEmail(employer);
        Result phoneNumberControl = checkPhoneNumber(employer);

        results.add(nullControl);
        results.add(emailControl);
        results.add(employerEmailControl);
        results.add(phoneNumberControl);

        for (var result : results){
            if (!result.isSuccess()){
                isFail = true;
                return result;
            }
        }

        if (! isFail){
            _employerDao.save(employer);

            StaffValidation staffValidation = new StaffValidation();
            staffValidation.setEmployerId(employer.getUserId());
            staffValidation.setValid(false);
            _staffValidationService.add(staffValidation);

            EmailValidation emailValidation = new EmailValidation();
            emailValidation.setUser_id(employer.getUserId());
            emailValidation.set_valid(false);
            _emailValidationService.add(emailValidation);

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


    private Result checkEmployerEmail(Employer employer) {
        String[] domain = employer.getEmail().split("@");
        if (employer.getWebAddress().contains(domain[1])){
            return new SuccessResult();
        }
        return new ErrorResult("The e-mail address must be an extension of the web address.");
    }

    private Result checkPhoneNumber(Employer employer){
        List<Employer> employers = _employerDao.findByPhoneNumber(employer.getPhoneNumber());
        if (employers.isEmpty()){
            return new SuccessResult();
        }
        return new ErrorResult("this phone number already exists in system");
    }


    private Result nullController(Employer employer) {
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
