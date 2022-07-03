package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJobPositionDao extends JpaRepository<JobPosition,Integer> {
    List<JobPosition> findByPositionName(String positionName);
}
