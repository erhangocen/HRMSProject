package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSkill;
import kodlamaio.humanResourcesProject.entities.dtos.JobSeekerSkillDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IJobSeekerSkillDao extends JpaRepository<JobSeekerSkill,Integer> {
    List<JobSeekerSkill> findByUserId(int id);

}
