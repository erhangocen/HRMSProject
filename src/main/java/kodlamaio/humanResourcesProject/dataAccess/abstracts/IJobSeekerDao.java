package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobSeekerDao extends JpaRepository<JobSeeker,Integer> {
}
