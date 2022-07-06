package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisementRequireSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobAdvertisementRequireSkillDao extends JpaRepository<JobAdvertisementRequireSkill, Integer> {
}
