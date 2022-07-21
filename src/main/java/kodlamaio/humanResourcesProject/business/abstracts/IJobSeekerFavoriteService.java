package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerFavorite;

import java.util.List;

public interface IJobSeekerFavoriteService {
    Result add(JobSeekerFavorite jobSeekerFavorite);
    Result delete(JobSeekerFavorite jobSeekerFavorite);
    DataResult<List<JobSeekerFavorite>> getByUserId(int id);
}
