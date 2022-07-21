package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.ICityService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.ICityDao;
import kodlamaio.humanResourcesProject.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements ICityService {

    private ICityDao _cityDao;

    @Autowired
    public CityManager(ICityDao cityDao) {
        this._cityDao = cityDao;
    }

    @Override
    public Result add(City city) {
        _cityDao.save(city);
        return new SuccessResult();
    }

    @Override
    public Result delete(City city) {
        _cityDao.delete(city);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(_cityDao.findAll());
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(_cityDao.findById(id));
    }
}
