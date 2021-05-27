package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.SystemUser;

import java.util.List;

public interface ISystemUserService {
    Result add(SystemUser systemUser);
    DataResult<List<SystemUser>> getAll();
}
