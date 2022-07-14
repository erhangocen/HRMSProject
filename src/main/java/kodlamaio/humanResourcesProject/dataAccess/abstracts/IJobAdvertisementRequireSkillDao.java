package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisement;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisementRequireSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJobAdvertisementRequireSkillDao extends JpaRepository<JobAdvertisementRequireSkill, Integer> {
    List<JobAdvertisementRequireSkill> findBySkillId(int id);
    List<JobAdvertisementRequireSkill> findByJobAdvertisementsId(int id);
}
