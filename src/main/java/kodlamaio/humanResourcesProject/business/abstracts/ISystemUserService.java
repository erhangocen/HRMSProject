package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.SystemUser;
import org.w3c.dom.ls.LSInput;

import java.util.List;

public interface ISystemUserService {
    Result add(SystemUser systemUser);
    Result delete(SystemUser systemUser);
    DataResult<List<SystemUser>> getAll();
}
