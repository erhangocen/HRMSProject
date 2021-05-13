package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.entities.concretes.JobPosition;

import java.util.List;

public interface IJobPositionService {
    List<JobPosition> getAll();
}
