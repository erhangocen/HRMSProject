package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerExperienceService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
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
        this._jobSeekerExperienceDao = jobSeekerExperienceDao;
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
}
