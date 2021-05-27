package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobPositionDao extends JpaRepository<JobPosition,Integer> {

}
