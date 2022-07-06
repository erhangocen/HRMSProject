package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobSeekerSkillDao extends JpaRepository<JobSeekerSkill,Integer> {
}
