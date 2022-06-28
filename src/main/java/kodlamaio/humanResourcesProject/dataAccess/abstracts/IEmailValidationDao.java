package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmailValidationDao extends JpaRepository<EmailValidation,Integer> {
}
