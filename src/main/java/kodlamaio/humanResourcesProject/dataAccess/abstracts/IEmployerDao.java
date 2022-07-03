package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployerDao extends JpaRepository<Employer,Integer> {
    List<Employer> findByPhoneNumber(String phoneNumber);
}
