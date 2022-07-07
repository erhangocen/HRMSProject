package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerSkillService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobSeekerSkillDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerSkillManager implements IJobSeekerSkillService {

    private IJobSeekerSkillDao _jobSeekerSkillDao;

    @Autowired
    public JobSeekerSkillManager(IJobSeekerSkillDao jobSeekerSkillDao) {
        this._jobSeekerSkillDao = jobSeekerSkillDao;
    }

    @Override
    public Result add(JobSeekerSkill jobSeekerSkill) {
        _jobSeekerSkillDao.save(jobSeekerSkill);
        return new SuccessResult();
    }

    @Override
    public Result delete(JobSeekerSkill jobSeekerSkill) {
        _jobSeekerSkillDao.delete(jobSeekerSkill);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobSeekerSkill>> getAll() {
        return new SuccessDataResult<List<JobSeekerSkill>>(_jobSeekerSkillDao.findAll());
    }
}
