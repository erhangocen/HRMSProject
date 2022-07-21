package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerLanguageService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobSeekerLanguageDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerLanguageManager implements IJobSeekerLanguageService {

    private IJobSeekerLanguageDao _jobSeekerLanguageDao;

    @Autowired
    public JobSeekerLanguageManager(IJobSeekerLanguageDao jobSeekerLanguageDao) {
        _jobSeekerLanguageDao = jobSeekerLanguageDao;
    }

    @Override
    public Result add(JobSeekerLanguage jobSeekerLanguage) {
        _jobSeekerLanguageDao.save(jobSeekerLanguage);
        return new SuccessResult();
    }

    @Override
    public Result delete(JobSeekerLanguage jobSeekerLanguage) {
        _jobSeekerLanguageDao.delete(jobSeekerLanguage);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobSeekerLanguage>> getAll() {
        return new SuccessDataResult<List<JobSeekerLanguage>>(_jobSeekerLanguageDao.findAll());
    }

    @Override
    public DataResult<List<JobSeekerLanguage>> getByUserId(int id) {
        return new SuccessDataResult<List<JobSeekerLanguage>>(_jobSeekerLanguageDao.findByUserId(id));
    }

    @Override
    public DataResult<List<JobSeekerLanguage>> getByUserIdOrderByLevelDesc(int id) {
        return new SuccessDataResult<List<JobSeekerLanguage>>(_jobSeekerLanguageDao.findByUserIdOrderByLevelDesc(id));
    }
}
