package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IStaffValidationService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IStaffValidationDao;
import kodlamaio.humanResourcesProject.entities.concretes.StaffValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffValidationManager implements IStaffValidationService {

    private IStaffValidationDao _staffValidationDao;

    @Autowired
    public StaffValidationManager(IStaffValidationDao _staffValidationDao) {
        super();
        this._staffValidationDao = _staffValidationDao;
    }

    @Override
    public Result add(StaffValidation staffValidation) {
        _staffValidationDao.save(staffValidation);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<StaffValidation>> getAll() {
        return new SuccessDataResult<List<StaffValidation>>(_staffValidationDao.findAll());
    }
}