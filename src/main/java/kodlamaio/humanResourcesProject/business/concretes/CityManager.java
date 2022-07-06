package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.ICityService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.City;

import java.util.List;

public class CityManager implements ICityService {
    @Override
    public Result add(City city) {
        return null;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return null;
    }
}
