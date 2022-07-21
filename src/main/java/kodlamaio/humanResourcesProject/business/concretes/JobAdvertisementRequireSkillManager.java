package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobAdvertisementRequireSkillService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobAdvertisementRequireSkillDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisementRequireSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementRequireSkillManager implements IJobAdvertisementRequireSkillService {

    private IJobAdvertisementRequireSkillDao _jobAdvertisementRequireSkillDao;

    @Autowired
    public JobAdvertisementRequireSkillManager(IJobAdvertisementRequireSkillDao jobAdvertisementRequireSkillDao) {
        this._jobAdvertisementRequireSkillDao = jobAdvertisementRequireSkillDao;
    }

    @Override
    public Result add(JobAdvertisementRequireSkill jobAdvertisementRequireSkill) {
        _jobAdvertisementRequireSkillDao.save(jobAdvertisementRequireSkill);
        return new SuccessResult();
    }

    @Override
    public Result delete(JobAdvertisementRequireSkill jobAdvertisementRequireSkill) {
        _jobAdvertisementRequireSkillDao.delete(jobAdvertisementRequireSkill);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobAdvertisementRequireSkill>> getAll() {
        return new SuccessDataResult<List<JobAdvertisementRequireSkill>>(_jobAdvertisementRequireSkillDao.findAll());
    }

    @Override
    public DataResult<List<JobAdvertisementRequireSkill>> getBySkillId(int id) {
        return new SuccessDataResult<List<JobAdvertisementRequireSkill>>(_jobAdvertisementRequireSkillDao.findBySkillId(id));
    }

    @Override
    public DataResult<List<JobAdvertisementRequireSkill>> getByJobAdvertisementId(int id) {
        return new SuccessDataResult<List<JobAdvertisementRequireSkill>>(_jobAdvertisementRequireSkillDao.findByJobAdvertisementsId(id));
    }
}
