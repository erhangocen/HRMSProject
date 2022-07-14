package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerExperience;

import java.util.List;

public interface IJobSeekerExperienceService {
    Result add(JobSeekerExperience jobSeekerExperience);
    Result delete(JobSeekerExperience jobSeekerExperience);

    DataResult<List<JobSeekerExperience>> getAll();
    DataResult<List<JobSeekerExperience>> getByUserId(int id);

    DataResult<List<JobSeekerExperience>> getByUserIdOrderByStartDateDesc(int id);
}
