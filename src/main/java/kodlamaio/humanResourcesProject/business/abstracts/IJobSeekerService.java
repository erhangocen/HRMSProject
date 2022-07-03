package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;

import java.util.List;

public interface IJobSeekerService {
    Result add(JobSeeker jobSeeker) throws Exception;
    DataResult<List<JobSeeker>> getAll();
}
