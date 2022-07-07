package kodlamaio.humanResourcesProject.business.concretes;


import kodlamaio.humanResourcesProject.business.abstracts.IEmailValidationService;
import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerService;
import kodlamaio.humanResourcesProject.business.abstracts.IUserService;
import kodlamaio.humanResourcesProject.business.validations.IMernisCheckService;
import kodlamaio.humanResourcesProject.core.utilities.results.*;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobSeekerDao;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobSeekerManager implements IJobSeekerService {

    private IJobSeekerDao _jobSeekerDao;
    private IUserService _userManager;
    private IMernisCheckService _mernisCheckService;
    private IEmailValidationService _emailValidationService;

    @Autowired
    public JobSeekerManager(IJobSeekerDao jobSeekerDao, IUserService userManager, IMernisCheckService mernisCheckService, IEmailValidationService emailValidationService) {
        super();
        this._jobSeekerDao = jobSeekerDao;
        this._userManager = userManager;
        this._mernisCheckService = mernisCheckService;
        this._emailValidationService = emailValidationService;
    }

    @Override
    public Result add(JobSeeker jobSeeker) throws Exception{

        List<Result> results = new ArrayList<Result>();
        boolean isFail = false;

        results.add(nullController(jobSeeker));
        results.add(checkNationalId(jobSeeker));
        results.add(_userManager.checkEmail(jobSeeker));
        results.add(_mernisCheckService.checkIfRealPerson(jobSeeker));

        for (var result: results){
            if (! result.isSuccess()) {
                isFail = true;
                return result;
            }
        }

        if (! isFail){
            _jobSeekerDao.save(jobSeeker);

            EmailValidation emailValidation = new EmailValidation();
            emailValidation.setUserId(jobSeeker.getUserId());
            emailValidation.setValid(false);
            _emailValidationService.add(emailValidation);

            return new SuccessResult();
        }
        else {
            return new ErrorResult();
        }

    }

    @Override
    public Result delete(JobSeeker jobSeeker) {
        _jobSeekerDao.delete(jobSeeker);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(_jobSeekerDao.findAll());
    }

    private Result checkNationalId(JobSeeker jobSeeker){
        List<JobSeeker> jobSeekers = _jobSeekerDao.findByNationalId(jobSeeker.getNationalId());
        if (jobSeekers.isEmpty()){
            return new SuccessResult();
        }
        return new ErrorResult("this user already exists in system");
    }

    private Result nullController(JobSeeker jobSeeker) {
        if (
                jobSeeker.getBirthYear() == ""
                        || jobSeeker.getFirstName() == ""
                        || jobSeeker.getLastName() == ""
                        || jobSeeker.getNationalId() == ""
                        || jobSeeker.getPassword() == ""
                        || jobSeeker.getEmail() == "" )
        {
            return new ErrorResult("you must fill in the fields");
        }
        return new SuccessResult();
    }
}
