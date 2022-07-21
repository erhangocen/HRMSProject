package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerExperienceService;
import kodlamaio.humanResourcesProject.core.utilities.results.*;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobSeekerExperienceDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerExperienceManager implements IJobSeekerExperienceService {

    private IJobSeekerExperienceDao _jobSeekerExperienceDao;

    @Autowired
    public JobSeekerExperienceManager(IJobSeekerExperienceDao jobSeekerExperienceDao) {
        _jobSeekerExperienceDao = jobSeekerExperienceDao;
    }

    @Override
    public Result add(JobSeekerExperience jobSeekerExperience) {
        _jobSeekerExperienceDao.save(jobSeekerExperience);
        return new SuccessResult();
    }

    @Override
    public Result delete(JobSeekerExperience jobSeekerExperience) {
        _jobSeekerExperienceDao.delete(jobSeekerExperience);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobSeekerExperience>> getAll() {
        return new SuccessDataResult<List<JobSeekerExperience>>(_jobSeekerExperienceDao.findAll());
    }

    @Override
    public DataResult<List<JobSeekerExperience>> getByUserId(int id) {
        return new SuccessDataResult<List<JobSeekerExperience>>(_jobSeekerExperienceDao.findByUserId(id));
    }

    @Override
    public DataResult<List<JobSeekerExperience>> getByUserIdOrderByStartDateDesc(int id) {
        return new SuccessDataResult<List<JobSeekerExperience>>(_jobSeekerExperienceDao.findByUserIdOrderByStartDateDesc(id));
    }
}
