package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobPositionService;
import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerPositionService;
import kodlamaio.humanResourcesProject.core.utilities.results.*;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobPositionDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobPosition;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPositionManager implements IJobPositionService {

    private IJobPositionDao _jobPositionDao;
    private IJobSeekerPositionService _jobSeekerPositionService;

    @Autowired
    public JobPositionManager(IJobPositionDao jobPositionDao, IJobSeekerPositionService jobSeekerPositionService) {
        super();
        _jobPositionDao = jobPositionDao;
        _jobSeekerPositionService = jobSeekerPositionService;
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
        return new SuccessDataResult<List<JobPosition>>(_jobPositionDao.findAll(),"Positions listed");
    }

    @Override
    public DataResult<List<JobPosition>> getNoHavePositions(int userId) {
        List<JobSeekerPosition> positions = _jobSeekerPositionService.getByUserId(userId).getData();
        List<JobPosition> havePositions = new ArrayList<>();;
        for (JobSeekerPosition position : positions){
            havePositions.add(position.getJobPosition());
        }
        List<JobPosition> noHavePositions = _jobPositionDao.findAll();
        noHavePositions.removeAll(havePositions);
        return new SuccessDataResult<List<JobPosition>>(noHavePositions);
    }

    private Result checkJobPositionName(JobPosition jobPosition){
        List<JobPosition> jobPositions = _jobPositionDao.findByPositionName(jobPosition.getPositionName());
        if (jobPositions.isEmpty()){
            return new SuccessResult();
        }
        return new ErrorResult("this position already exist");
    }

    @Override
    public Result delete(JobPosition jobPosition){
        _jobPositionDao.delete(jobPosition);
        return new SuccessResult();
    }
}
