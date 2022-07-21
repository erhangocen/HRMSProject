package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerReferenceService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobSeekerReferenceDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerReferenceManager implements IJobSeekerReferenceService {

    private IJobSeekerReferenceDao _jobSeekerReferenceDao;

    @Autowired
    public JobSeekerReferenceManager(IJobSeekerReferenceDao jobSeekerReferenceDao) {
        _jobSeekerReferenceDao = jobSeekerReferenceDao;
    }

    @Override
    public Result add(JobSeekerReference jobSeekerReference) {
        _jobSeekerReferenceDao.save(jobSeekerReference);
        return new SuccessResult();
    }

    @Override
    public Result delete(JobSeekerReference jobSeekerReference) {
        _jobSeekerReferenceDao.delete(jobSeekerReference);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobSeekerReference>> getAllReferencesByUserId(int id) {
        return new SuccessDataResult<List<JobSeekerReference>>(_jobSeekerReferenceDao.findByUserId(id));
    }
}
