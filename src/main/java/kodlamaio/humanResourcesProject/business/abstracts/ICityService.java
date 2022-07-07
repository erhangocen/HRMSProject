package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.City;

import java.util.List;

public interface ICityService {

    Result add(City city);
    Result delete(City city);

    DataResult<List<City>> getAll();
}
