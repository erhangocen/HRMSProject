package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerLanguageService;
import kodlamaio.humanResourcesProject.business.abstracts.ILanguageService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.ILanguageDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerLanguage;
import kodlamaio.humanResourcesProject.entities.concretes.Language;
import kodlamaio.humanResourcesProject.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements ILanguageService {

    private ILanguageDao _languageDao;
    private IJobSeekerLanguageService _jobSeekerLanguageService;

    @Autowired
    public LanguageManager(ILanguageDao languageDao, IJobSeekerLanguageService jobSeekerLanguageService) {
        _languageDao = languageDao;
        _jobSeekerLanguageService = jobSeekerLanguageService;
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

    @Override
    public DataResult<List<Language>> getNoHaveLanguages(int userId) {
        List<JobSeekerLanguage> languages =_jobSeekerLanguageService.getByUserId(userId).getData();
        List<Language> haveLanguages = new ArrayList<>();;
        for (JobSeekerLanguage language : languages){
            haveLanguages.add(language.getLanguage());
        }
        List<Language> noHaveLanguages = _languageDao.findAll();
        noHaveLanguages.removeAll(haveLanguages);
        return new SuccessDataResult<List<Language>>(noHaveLanguages);
    }
}
