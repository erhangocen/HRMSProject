package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage,Integer> {
    List<JobSeekerLanguage> findByUserId(int id);
    List<JobSeekerLanguage> findByUserIdOrderByLevelDesc(int id);
}
