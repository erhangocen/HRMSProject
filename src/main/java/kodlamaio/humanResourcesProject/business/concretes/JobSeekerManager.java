package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobSeekerDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements IJobSeekerService {

    private IJobSeekerDao _jobSeekerDao;

    @Autowired
    public JobSeekerManager(IJobSeekerDao _jobSeekerDao) {
        super();
        this._jobSeekerDao = _jobSeekerDao;
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        _jobSeekerDao.save(jobSeeker);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(_jobSeekerDao.findAll());
    }
}
