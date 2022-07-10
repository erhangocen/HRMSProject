package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.ILanguageService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.ILanguageDao;
import kodlamaio.humanResourcesProject.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements ILanguageService {

    private ILanguageDao _languageDao;

    @Autowired
    public LanguageManager(ILanguageDao languageDao) {
        this._languageDao = languageDao;
    }

    @Override
    public Result add(Language language) {
        _languageDao.save(language);
        return new SuccessResult();
    }

    @Override
    public Result delete(Language language) {
        _languageDao.delete(language);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(_languageDao.findAll());
    }
}
