package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployerDao extends JpaRepository<Employer,Integer> {
}
