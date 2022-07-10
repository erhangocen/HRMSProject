package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILanguageDao extends JpaRepository<Language,Integer> {
}
