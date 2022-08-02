package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.Language;

import java.util.List;

public interface ILanguageService {
    Result add(Language language);
    Result delete(Language language);

    DataResult<List<Language>> getAll();
    DataResult<List<Language>> getNoHaveLanguages(int userId);
}
