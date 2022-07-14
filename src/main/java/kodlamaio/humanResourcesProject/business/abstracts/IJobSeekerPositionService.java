package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerPosition;

import java.util.List;

public interface IJobSeekerPositionService {

    Result add(JobSeekerPosition jobSeekerPosition);
    Result delete(JobSeekerPosition jobSeekerPosition);
    DataResult<List<JobSeekerPosition>> getAll();
    DataResult<List<JobSeekerPosition>> getByUserId(int id);

}
