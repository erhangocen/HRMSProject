package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerReference;

import java.util.List;

public interface IJobSeekerReferenceService {

    Result add(JobSeekerReference jobSeekerReference);
    Result delete(JobSeekerReference jobSeekerReference);

    DataResult<List<JobSeekerReference>> getAllReferencesByUserId(int id);
}
