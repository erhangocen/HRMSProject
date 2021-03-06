package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerPositionService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobSeekerPositionDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerPositionManager implements IJobSeekerPositionService {

    private IJobSeekerPositionDao _jobSeekerPositionDao;

    @Autowired
    public JobSeekerPositionManager(IJobSeekerPositionDao jobSeekerPositionDao) {
        super();
        _jobSeekerPositionDao = jobSeekerPositionDao;
    }

    @Override
    public Result add(JobSeekerPosition jobSeekerPosition) {
        _jobSeekerPositionDao.save(jobSeekerPosition);
        return new SuccessResult();
    }

    @Override
    public Result delete(JobSeekerPosition jobSeekerPosition) {
        _jobSeekerPositionDao.delete(jobSeekerPosition);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobSeekerPosition>> getAll() {
        return new SuccessDataResult<List<JobSeekerPosition>>(_jobSeekerPositionDao.findAll());
    }

    @Override
    public DataResult<List<JobSeekerPosition>> getByUserId(int id) {
        return new SuccessDataResult<List<JobSeekerPosition>>(_jobSeekerPositionDao.findByUserId(id));
    }
}
