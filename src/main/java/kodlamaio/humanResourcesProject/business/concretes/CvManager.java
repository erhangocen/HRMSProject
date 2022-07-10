package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.ICvService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.ICvDao;
import kodlamaio.humanResourcesProject.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements ICvService {

    private ICvDao _cvDao;

    @Autowired
    public CvManager(ICvDao cvDao) {
        _cvDao = cvDao;
    }

    @Override
    public Result add(Cv cv) {
        _cvDao.save(cv);
        return new SuccessResult();
    }

    @Override
    public Result delete(Cv cv) {
        _cvDao.delete(cv);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(_cvDao.findAll());
    }
}
