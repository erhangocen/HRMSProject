package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.StaffValidation;

import java.util.List;

public interface IStaffValidationService {

    Result add(StaffValidation staffValidation);
    Result validate(int staffValidationId, int systemUserId);
    Result delete(StaffValidation staffValidation);
    DataResult<List<StaffValidation>> getAll();
    DataResult<StaffValidation> getByUserId(int id);

}
