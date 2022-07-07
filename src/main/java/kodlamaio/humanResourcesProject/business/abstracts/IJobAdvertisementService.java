package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.City;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisement;

import java.util.List;

public interface IJobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    Result delete(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getAll();
}
