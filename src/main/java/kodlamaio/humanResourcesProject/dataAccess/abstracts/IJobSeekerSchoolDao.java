package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSchool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobSeekerSchoolDao extends JpaRepository<JobSeekerSchool, Integer> {
}
