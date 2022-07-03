package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobPositionService;
import kodlamaio.humanResourcesProject.core.utilities.results.*;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobPositionDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        List<Result> results = new ArrayList<>();
        boolean isFail = false;

        results.add(checkJobPositionName(jobPosition));

        for (var result : results){
            if (!result.isSuccess()){
                isFail = true;
                return result;
            }
        }

        if (!isFail){
            _jobPositionDao.save(jobPosition);
            return new SuccessResult();
        }
        else {
            return new ErrorResult();
        }
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(_jobPositionDao.findAll());
    }

    private Result checkJobPositionName(JobPosition jobPosition){
        List<JobPosition> jobPositions = _jobPositionDao.findByPositionName(jobPosition.getPositionName());
        if (jobPositions.isEmpty()){
            return new SuccessResult();
        }
        return new ErrorResult("this position already exist");
    }
}
