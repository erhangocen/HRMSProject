package kodlamaio.humanResourcesProject.dataAccess.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJobSeekerFavoriteDao extends JpaRepository<JobSeekerFavorite,Integer> {
    List<JobSeekerFavorite> findByUserIdOrderByAddDateDesc(int id);
}
