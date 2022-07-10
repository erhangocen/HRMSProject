package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSchool;

import java.util.List;

public interface IJobSeekerSchoolService {
    Result add(JobSeekerSchool jobSeekerSchool);
    Result delete(JobSeekerSchool jobSeekerSchool);

    DataResult<List<JobSeekerSchool>> getAll();
}
