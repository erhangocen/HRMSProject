package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.Employer;

import java.util.List;

public interface IEmployerService {

    Result add(Employer employer);
    Result update(Employer employer);
    DataResult<List<Employer>> getAll();

}
