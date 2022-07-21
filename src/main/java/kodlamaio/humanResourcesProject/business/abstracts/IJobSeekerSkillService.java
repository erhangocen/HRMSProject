package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSkill;

import java.util.List;

public interface IJobSeekerSkillService {
    Result add(JobSeekerSkill jobSeekerSkill);
    Result delete(JobSeekerSkill jobSeekerSkill);
    DataResult<List<JobSeekerSkill>> getAll();
    DataResult<List<JobSeekerSkill>> getByUserId(int id);

}
