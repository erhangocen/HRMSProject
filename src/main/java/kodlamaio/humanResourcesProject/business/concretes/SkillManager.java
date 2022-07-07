package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.ISkillService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.ISkillDao;
import kodlamaio.humanResourcesProject.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillManager implements ISkillService {

    private ISkillDao _skillDao;

    @Autowired
    public SkillManager(ISkillDao skillDao) {
        this._skillDao = skillDao;
    }

    @Override
    public Result add(Skill skill) {
        _skillDao.save(skill);
        return new SuccessResult();
    }

    @Override
    public Result delete(Skill skill) {
        _skillDao.delete(skill);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(_skillDao.findAll());
    }
}
