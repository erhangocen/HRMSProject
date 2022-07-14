package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJobSeekerExperienceDao extends JpaRepository<JobSeekerExperience,Integer> {
    List<JobSeekerExperience> findByUserId(int id);
    List<JobSeekerExperience> findByUserIdOrderByStartDateDesc(int id);
}
