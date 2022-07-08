package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICvDao extends JpaRepository<Cv,Integer> {
}
