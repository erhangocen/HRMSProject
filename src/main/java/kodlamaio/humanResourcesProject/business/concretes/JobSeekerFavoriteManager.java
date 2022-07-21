package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerFavoriteService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobSeekerFavoriteDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerFavorite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerFavoriteManager implements IJobSeekerFavoriteService {

    private IJobSeekerFavoriteDao _jobSeekerFavoriteDao;

    public JobSeekerFavoriteManager(IJobSeekerFavoriteDao jobSeekerFavoriteDao) {
        this._jobSeekerFavoriteDao = jobSeekerFavoriteDao;
    }

    @Override
    public Result add(JobSeekerFavorite jobSeekerFavorite) {
        _jobSeekerFavoriteDao.save(jobSeekerFavorite);
        return new SuccessResult();
    }

    @Override
    public Result delete(JobSeekerFavorite jobSeekerFavorite) {
        _jobSeekerFavoriteDao.delete(jobSeekerFavorite);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobSeekerFavorite>> getByUserId(int id) {
        return new SuccessDataResult<List<JobSeekerFavorite>>(_jobSeekerFavoriteDao.findByUserIdOrderByAddDateDesc(id));
    }
}
