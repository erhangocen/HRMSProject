package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.City;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisement;

import java.util.List;

public interface IJobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    Result delete(JobAdvertisement jobAdvertisement);
    Result advertisementActiveFalse(int jobAdvertisementId);
    Result advertisementActiveTrue(int jobAdvertisementId);
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getActiveAdvertisements();

    DataResult<List<JobAdvertisement>> getActiveAdvertisementsByEmployer(int employerId);
    DataResult<List<JobAdvertisement>> getActiveAdvertisementsByDeadlineAsc();
    DataResult<List<JobAdvertisement>> getActiveAdvertisementsByDeadlineDesc();
}
