package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.City;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisementRequireSkill;

import java.util.List;

public interface IJobAdvertisementRequireSkillService {
    Result add(JobAdvertisementRequireSkill jobAdvertisementRequireSkill);
    Result delete(JobAdvertisementRequireSkill jobAdvertisementRequireSkill);
    DataResult<List<JobAdvertisementRequireSkill>> getAll();
}
