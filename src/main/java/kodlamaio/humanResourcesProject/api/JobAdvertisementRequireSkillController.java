package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobAdvertisementRequireSkillService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisement;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisementRequireSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisementRequireSkill/")
public class JobAdvertisementRequireSkillController {
    private IJobAdvertisementRequireSkillService _jobAdvertisementRequireSkillService;

    @Autowired
    public JobAdvertisementRequireSkillController(IJobAdvertisementRequireSkillService jobAdvertisementRequireSkillService) {
        this._jobAdvertisementRequireSkillService = jobAdvertisementRequireSkillService;
    }

    @PostMapping("add")
    public Result add(@RequestBody JobAdvertisementRequireSkill jobAdvertisementRequireSkill){
        return _jobAdvertisementRequireSkillService.add(jobAdvertisementRequireSkill);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestBody JobAdvertisementRequireSkill jobAdvertisementRequireSkill){
        return _jobAdvertisementRequireSkillService.delete(jobAdvertisementRequireSkill);
    }

    @GetMapping("getAll")
    public DataResult<List<JobAdvertisementRequireSkill>> getAll(){
        return _jobAdvertisementRequireSkillService.getAll();
    }
}
