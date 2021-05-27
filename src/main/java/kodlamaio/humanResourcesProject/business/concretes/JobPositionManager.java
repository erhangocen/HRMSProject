package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobPositionService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobPositionDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements IJobPositionService {

    private IJobPositionDao _jobPositionDao;

    @Autowired
    public JobPositionManager(IJobPositionDao _jobPositionDao) {
        super();
        this._jobPositionDao = _jobPositionDao;
    }

    @Override
    public Result add(JobPosition jobPosition) {
        _jobPositionDao.save(jobPosition);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(_jobPositionDao.findAll(),"job positions listed");
    }
}
