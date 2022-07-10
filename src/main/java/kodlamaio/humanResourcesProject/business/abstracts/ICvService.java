package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.City;
import kodlamaio.humanResourcesProject.entities.concretes.Cv;

import java.util.List;

public interface ICvService {

    Result add(Cv cv);
    Result delete(Cv cv);

    DataResult<List<Cv>> getAll();
}
