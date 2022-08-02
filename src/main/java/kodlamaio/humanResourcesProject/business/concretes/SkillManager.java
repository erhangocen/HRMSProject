package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerSkillService;
import kodlamaio.humanResourcesProject.business.abstracts.ISkillService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.ISkillDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSkill;
import kodlamaio.humanResourcesProject.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillManager implements ISkillService {

    private ISkillDao _skillDao;
    private IJobSeekerSkillService _jobSeekerSkillService;

    @Autowired
    public SkillManager(ISkillDao skillDao, IJobSeekerSkillService jobSeekerSkillService) {
        _skillDao = skillDao;
        _jobSeekerSkillService = jobSeekerSkillService;
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

    @Override
    public DataResult<List<Skill>> getNoHaveUser(int userId) {
        List<JobSeekerSkill> skills1 = _jobSeekerSkillService.getByUserId(userId).getData();
        List<Skill> haveSkills = new ArrayList<>();;
        for (JobSeekerSkill skill : skills1){
            haveSkills.add(skill.getSkill());
        }
        List<Skill> noHaveSkills = _skillDao.findAll();
        noHaveSkills.removeAll(haveSkills);
        return new SuccessDataResult<List<Skill>>(noHaveSkills);
    }
}
