package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IJobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    List<JobAdvertisement> findByIsActiveTrue();
    List<JobAdvertisement> findByEmployer_UserIdAndIsActiveTrue(int employerId);
    List<JobAdvertisement> findByOrderByApplicationDeadlineAsc();
}
