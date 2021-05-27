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
    public JobSeekerPositionManager(IJobSeekerPositionDao _jobSeekerPositionDao) {
        super();
        this._jobSeekerPositionDao = _jobSeekerPositionDao;
    }

    @Override
    public Result add(JobSeekerPosition jobSeekerPosition) {
        _jobSeekerPositionDao.save(jobSeekerPosition);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobSeekerPosition>> getAll() {
        return new SuccessDataResult<List<JobSeekerPosition>>(_jobSeekerPositionDao.findAll());
    }
}
