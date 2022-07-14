package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerSchoolService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobSeekerSchoolDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerSchoolManager implements IJobSeekerSchoolService {

    private IJobSeekerSchoolDao _jobSeekerSchoolDao;

    @Autowired
    public JobSeekerSchoolManager(IJobSeekerSchoolDao jobSeekerSchoolDao) {
        this._jobSeekerSchoolDao = jobSeekerSchoolDao;
    }


    @Override
    public Result add(JobSeekerSchool jobSeekerSchool) {
        _jobSeekerSchoolDao.save(jobSeekerSchool);
        return new SuccessResult();
    }

    @Override
    public Result delete(JobSeekerSchool jobSeekerSchool) {
        _jobSeekerSchoolDao.delete(jobSeekerSchool);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobSeekerSchool>> getAll() {
        return new SuccessDataResult<List<JobSeekerSchool>>(_jobSeekerSchoolDao.findAll());
    }

    @Override
    public DataResult<List<JobSeekerSchool>> getByUserId(int id) {
        return new SuccessDataResult<List<JobSeekerSchool>>(_jobSeekerSchoolDao.findByUserId(id));
    }

    @Override
    public DataResult<List<JobSeekerSchool>> getByUserIdOrderByStartYearDesc(int id) {
        return new SuccessDataResult<List<JobSeekerSchool>>(_jobSeekerSchoolDao.findByUserIdOrderByStartYearDesc(id));
    }
}
