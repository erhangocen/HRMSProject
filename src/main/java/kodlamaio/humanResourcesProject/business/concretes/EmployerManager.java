package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IEmployerService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IEmployerDao;
import kodlamaio.humanResourcesProject.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements IEmployerService {

    private IEmployerDao _employerDao;

    @Autowired
    public EmployerManager(IEmployerDao _employerDao) {
        super();
        this._employerDao = _employerDao;
    }

    @Override
    public Result add(Employer employer) {
        _employerDao.save(employer);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(_employerDao.findAll());
    }
}
