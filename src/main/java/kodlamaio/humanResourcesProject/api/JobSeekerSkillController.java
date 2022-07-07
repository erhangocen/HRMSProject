package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerSkillService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerPosition;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobSeekerSkill/")
public class JobSeekerSkillController {
    private IJobSeekerSkillService _jobSeekerSkillService;

    @Autowired
    public JobSeekerSkillController(IJobSeekerSkillService jobSeekerSkillService) {
        this._jobSeekerSkillService = jobSeekerSkillService;
    }

    @GetMapping("getAll")
    public DataResult<List<JobSeekerSkill>> getAll(){
        return _jobSeekerSkillService.getAll();
    }

    @PostMapping("add")
    public Result add(JobSeekerSkill jobSeekerSkill){
        return _jobSeekerSkillService.add(jobSeekerSkill);
    }

    @DeleteMapping("delete")
    public Result delete(JobSeekerSkill jobSeekerSkill){
        return _jobSeekerSkillService.delete(jobSeekerSkill);
    }
}
