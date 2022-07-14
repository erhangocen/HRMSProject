package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJobSeekerPositionDao extends JpaRepository<JobSeekerPosition,Integer> {
    List<JobSeekerPosition> findByUserId(int id);
}
