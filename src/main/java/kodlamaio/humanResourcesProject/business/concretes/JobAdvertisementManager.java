package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobAdvertisementService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisement;

import java.util.List;

public class JobAdvertisementManager implements IJobAdvertisementService {
    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        return null;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return null;
    }
}
