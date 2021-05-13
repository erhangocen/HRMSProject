package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobPositionService;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobPositionDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements IJobPositionService {

    private final IJobPositionDao _jobPositionDao;

    @Autowired
    public JobPositionManager(IJobPositionDao _jobPositionDao) {
        super();
        this._jobPositionDao = _jobPositionDao;
    }

    @Override
    public List<JobPosition> getAll() {
        return _jobPositionDao.findAll();
    }
}
