package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.ISkillService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.Skill;

import java.util.List;

public class SkillManager implements ISkillService {
    @Override
    public Result add(Skill skill) {
        return null;
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return null;
    }
}
