package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJobSeekerCertificateDao extends JpaRepository<JobSeekerCertificate,Integer> {
    List<JobSeekerCertificate> findByUserIdOrderByCertificateYearDesc(int userId);
}
