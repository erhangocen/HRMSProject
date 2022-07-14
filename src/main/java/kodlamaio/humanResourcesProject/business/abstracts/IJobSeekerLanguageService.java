package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerLanguage;

import java.util.List;

public interface IJobSeekerLanguageService {
    Result add(JobSeekerLanguage jobSeekerLanguage);
    Result delete(JobSeekerLanguage jobSeekerLanguage);

    DataResult<List<JobSeekerLanguage>> getAll();
    DataResult<List<JobSeekerLanguage>> getByUserId(int id);
    DataResult<List<JobSeekerLanguage>> getByUserIdOrderByLevelDesc(int id);
}
