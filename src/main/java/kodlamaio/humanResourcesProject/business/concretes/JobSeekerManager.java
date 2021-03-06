package kodlamaio.humanResourcesProject.business.concretes;


import kodlamaio.humanResourcesProject.business.abstracts.*;
import kodlamaio.humanResourcesProject.business.validations.mernis.IMernisCheckService;
import kodlamaio.humanResourcesProject.core.utilities.results.*;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobSeekerDao;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;
import kodlamaio.humanResourcesProject.entities.concretes.Photo;
import kodlamaio.humanResourcesProject.entities.dtos.CvDto;
import kodlamaio.humanResourcesProject.entities.dtos.JobSeekerCoverLetterDto;
import kodlamaio.humanResourcesProject.entities.dtos.JobSeekerLinksDto;
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
    private IJobSeekerExperienceService _jobSeekerExperienceService;
    private IJobSeekerLanguageService _jobSeekerLanguageService;
    private IJobSeekerPositionService _jobSeekerPositionService;
    private IJobSeekerSchoolService _jobSeekerSchoolService;
    private IJobSeekerSkillService _jobSeekerSkillService;
    private IPhotoService _photoService;
    private IJobSeekerReferenceService _jobSeekerReferenceService;
    private IJobSeekerCertificateService _jobSeekerCertificateService;

    @Autowired
    public JobSeekerManager(IJobSeekerDao jobSeekerDao, IUserService userManager, IMernisCheckService mernisCheckService, IEmailValidationService emailValidationService, IJobSeekerExperienceService jobSeekerExperienceService, IJobSeekerLanguageService jobSeekerLanguageService, IJobSeekerPositionService jobSeekerPositionService, IJobSeekerSchoolService jobSeekerSchoolService, IJobSeekerSkillService jobSeekerSkillService, IPhotoService photoService, ICityService cityService, IJobSeekerReferenceService jobSeekerReferenceService, IJobSeekerCertificateService jobSeekerCertificateService) {
        super();
        _jobSeekerDao = jobSeekerDao;
        _userManager = userManager;
        _mernisCheckService = mernisCheckService;
        _emailValidationService = emailValidationService;
        _jobSeekerExperienceService = jobSeekerExperienceService;
        _jobSeekerLanguageService = jobSeekerLanguageService;
        _jobSeekerPositionService = jobSeekerPositionService;
        _jobSeekerSchoolService = jobSeekerSchoolService;
        _jobSeekerSkillService = jobSeekerSkillService;
        _photoService = photoService;
        _jobSeekerReferenceService = jobSeekerReferenceService;
        _jobSeekerCertificateService = jobSeekerCertificateService;
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


            Photo photo = new Photo();
            photo.setUserId(jobSeeker.getUserId());
            photo.setPhotoUrl("https://res.cloudinary.com/dbzf16o0x/image/upload/v1657832793/Ec6ferCXYAA6XB__ednbzx.jpg");
            _photoService.add(photo);

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

    @Override
    public DataResult<CvDto> getCv(int userId) {
        CvDto cvDto = new CvDto();
        JobSeeker jobSeeker = _jobSeekerDao.findById(userId);
        cvDto.setJobSeeker(jobSeeker);
        cvDto.setPhoto(_photoService.getByUserId(userId).getData());
        cvDto.setJobSeekerCertificates(_jobSeekerCertificateService.getAllCertificatesByUserId(userId).getData());
        cvDto.setJobSeekerReferences(_jobSeekerReferenceService.getAllReferencesByUserId(userId).getData());
        cvDto.setJobSeekerExperiences(_jobSeekerExperienceService.getByUserIdOrderByStartDateDesc(userId).getData());
        cvDto.setJobSeekerLanguages(_jobSeekerLanguageService.getByUserIdOrderByLevelDesc(userId).getData());
        cvDto.setJobSeekerPositions(_jobSeekerPositionService.getByUserId(userId).getData());
        cvDto.setJobSeekerSchools(_jobSeekerSchoolService.getByUserIdOrderByStartYearDesc(userId).getData());
        cvDto.setJobSeekerSkills(_jobSeekerSkillService.getByUserId(userId).getData());
        return new SuccessDataResult<CvDto>(cvDto);
    }

    @Override
    public Result updateLinks(JobSeekerLinksDto jobSeekerLinksDto) {
        JobSeeker jobSeeker = _jobSeekerDao.findById(jobSeekerLinksDto.getUserId());
        jobSeeker.setGithubLink(jobSeekerLinksDto.getGithubLink());
        jobSeeker.setLinkedinLink(jobSeekerLinksDto.getLinkedinLink());
        jobSeeker.setInstagramLink(jobSeekerLinksDto.getInstagramLink());
        jobSeeker.setTwitterLink(jobSeekerLinksDto.getTwitterLink());
        _jobSeekerDao.save(jobSeeker);
        return new SuccessResult();
    }


    @Override
    public Result updateCoverLetter(JobSeekerCoverLetterDto jobSeekerCoverLetterDto) {
        JobSeeker jobSeeker = _jobSeekerDao.findById(jobSeekerCoverLetterDto.getUserId());
        jobSeeker.setCoverLetter(jobSeekerCoverLetterDto.getCoverLetter());
        _jobSeekerDao.save(jobSeeker);
        return new SuccessResult();
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
