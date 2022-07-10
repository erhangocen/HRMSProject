package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage,Integer> {
}
