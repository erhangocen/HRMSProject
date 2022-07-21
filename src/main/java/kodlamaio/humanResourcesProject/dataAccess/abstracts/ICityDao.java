package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityDao extends JpaRepository<City,Integer> {
    City findById(int id);
}
