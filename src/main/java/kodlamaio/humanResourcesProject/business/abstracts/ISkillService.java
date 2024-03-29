package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.Skill;

import java.util.List;

public interface ISkillService {
    Result add(Skill skill);
    Result delete(Skill skill);
    DataResult<List<Skill>> getAll();
    DataResult<List<Skill>> getNoHaveUser(int userId);
}
