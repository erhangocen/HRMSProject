package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.ISystemUserService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.ISystemUserDao;
import kodlamaio.humanResourcesProject.entities.concretes.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserManager implements ISystemUserService {

    private ISystemUserDao _systemUserDao;

    @Autowired
    public SystemUserManager(ISystemUserDao systemUserDao) {
        _systemUserDao = systemUserDao;
    }


    @Override
    public Result add(SystemUser systemUser) {
        _systemUserDao.save(systemUser);
        return new SuccessResult();
    }

    @Override
    public Result delete(SystemUser systemUser) {
        _systemUserDao.delete(systemUser);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<SystemUser>> getAll() {
        return new SuccessDataResult<List<SystemUser>>(_systemUserDao.findAll());
    }
}
