package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISystemUserDao extends JpaRepository<SystemUser,Integer> {
}
