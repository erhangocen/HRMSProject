package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSchool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJobSeekerSchoolDao extends JpaRepository<JobSeekerSchool, Integer> {
    List<JobSeekerSchool> findByUserId(int id);
    List<JobSeekerSchool> findByUserIdOrderByStartYearDesc(int id);
}
