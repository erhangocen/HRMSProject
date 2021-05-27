package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.StaffValidation;

import java.util.List;

public interface IStaffValidationService {

    Result add(StaffValidation staffValidation);
    DataResult<List<StaffValidation>> getAll();

}
