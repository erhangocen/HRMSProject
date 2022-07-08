package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobSeekerExperienceDao extends JpaRepository<JobSeekerExperience,Integer> {
}
