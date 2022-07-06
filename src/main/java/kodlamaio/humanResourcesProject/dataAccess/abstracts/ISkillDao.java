package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISkillDao extends JpaRepository<Skill,Integer> {
}
