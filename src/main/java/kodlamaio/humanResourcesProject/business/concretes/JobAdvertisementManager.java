package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IEmailValidationService;
import kodlamaio.humanResourcesProject.business.abstracts.IJobAdvertisementService;
import kodlamaio.humanResourcesProject.business.abstracts.IStaffValidationService;
import kodlamaio.humanResourcesProject.core.utilities.results.*;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobAdvertisementDao;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import kodlamaio.humanResourcesProject.entities.concretes.Employer;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisement;
import kodlamaio.humanResourcesProject.entities.concretes.StaffValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobAdvertisementManager implements IJobAdvertisementService {

    private IJobAdvertisementDao _jobAdvertisementDao;
    private IEmailValidationService _emailValidationService;
    private IStaffValidationService _staffValidationService;

    @Autowired
    public JobAdvertisementManager(IJobAdvertisementDao jobAdvertisementDao, IEmailValidationService emailValidationService, IStaffValidationService staffValidationService) {
        this._jobAdvertisementDao = jobAdvertisementDao;
        this._emailValidationService = emailValidationService;
        _staffValidationService = staffValidationService;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {

        List<Result> results = new ArrayList<>();
        boolean isFail = false;

        Result employerEmailControl = checkEmployerEmailValidation(jobAdvertisement.getEmployer());
        Result employerStaffValidationControl = checkEmployerStaffValidation(jobAdvertisement.getEmployer());

        results.add(employerEmailControl);
        results.add(employerStaffValidationControl);

        for (var result : results){
            if(! result.isSuccess()){
                isFail = true;
                return result;
            }
        }

        if (! isFail){
            _jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult();
        }
        else {
            return new ErrorResult();
        }

    }

    @Override
    public Result delete(JobAdvertisement jobAdvertisement) {
        _jobAdvertisementDao.delete(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public Result advertisementActiveFalse(int jobAdvertisementId) {
        JobAdvertisement jobAdvertisement = _jobAdvertisementDao.findById(jobAdvertisementId);
        jobAdvertisement.setActive(false);
        _jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public Result advertisementActiveTrue(int jobAdvertisementId) {
        JobAdvertisement jobAdvertisement = _jobAdvertisementDao.findById(jobAdvertisementId);
        jobAdvertisement.setActive(true);
        _jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(_jobAdvertisementDao.findAll());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveAdvertisements() {
        return new SuccessDataResult<List<JobAdvertisement>>(_jobAdvertisementDao.findByIsActiveTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveAdvertisementsByEmployer(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(_jobAdvertisementDao.findByEmployer_UserIdAndIsActiveTrue(employerId));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveAdvertisementsByDeadlineAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>(_jobAdvertisementDao.findByIsActiveTrueOrderByApplicationDeadlineAsc());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveAdvertisementsByDeadlineDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(_jobAdvertisementDao.findByIsActiveTrueOrderByApplicationDeadlineDesc());
    }

    private Result checkEmployerEmailValidation(Employer employer){
        EmailValidation emailValidation = _emailValidationService.getByUserId(employer.getUserId()).getData();
        if(emailValidation.isValid()){
            return new SuccessResult();
        }
        return new ErrorResult("Email error");
    }

    private Result checkEmployerStaffValidation(Employer employer){
        StaffValidation staffValidation = _staffValidationService.getByUserId(employer.getUserId()).getData();
        if (staffValidation.isValid()){
            return new SuccessResult();
        }
        return new ErrorResult("staff validation error");
    }
}
