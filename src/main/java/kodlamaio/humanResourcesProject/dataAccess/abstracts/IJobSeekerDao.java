package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJobSeekerDao extends JpaRepository<JobSeeker,Integer> {
    List<JobSeeker> findByNationalId(String nationalId);
    JobSeeker findById(int id);
}
