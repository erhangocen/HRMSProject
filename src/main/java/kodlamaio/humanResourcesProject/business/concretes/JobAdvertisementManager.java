package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobAdvertisementService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobAdvertisementDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements IJobAdvertisementService {

    private IJobAdvertisementDao _jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(IJobAdvertisementDao jobAdvertisementDao) {
        this._jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        _jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public Result delete(JobAdvertisement jobAdvertisement) {
        _jobAdvertisementDao.delete(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(_jobAdvertisementDao.findAll());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveAdvertisements() {
        return new SuccessDataResult<List<JobAdvertisement>>(_jobAdvertisementDao.findByIsActiveTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveAdvertisementsByEmployer(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(_jobAdvertisementDao.findByEmployer_UserIdAndIsActiveTrue(employerId));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveAdvertisementsByDeadlineAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>(_jobAdvertisementDao.findByOrderByApplicationDeadlineAsc());
    }
}
