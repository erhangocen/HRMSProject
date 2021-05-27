package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobSeekerPositionDao extends JpaRepository<JobSeekerPosition,Integer> {
}
