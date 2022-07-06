package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerSkillService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSkill;

import java.util.List;

public class JobSeekerSkillManager implements IJobSeekerSkillService {
    @Override
    public Result add(JobSeekerSkill jobSeekerSkill) {
        return null;
    }

    @Override
    public DataResult<List<JobSeekerSkill>> getAll() {
        return null;
    }
}
