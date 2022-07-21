package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerReference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJobSeekerReferenceDao extends JpaRepository<JobSeekerReference, Integer> {
    List<JobSeekerReference> findByUserId(int id);
}
