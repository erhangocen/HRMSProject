package kodlamaio.humanResourcesProject.business.validations;

import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;

public interface IMernisCheckService {
    Result checkIfRealPerson(JobSeeker jobSeeker) throws Exception;
}
