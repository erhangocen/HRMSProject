package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.StaffValidation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStaffValidationDao extends JpaRepository<StaffValidation,Integer> {
}
