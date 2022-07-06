package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobPosition;

import java.util.List;

public interface IJobPositionService {

    Result add(JobPosition jobPosition);
    Result delete(JobPosition jobPosition);
    DataResult<List<JobPosition>> getAll();

}
