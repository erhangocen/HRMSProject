package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerSkillService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerPosition;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_jobSeekerSkillService.getAll());
    }

    @GetMapping("getByUserId")
    public ResponseEntity<?> getByUserId(int id){
        return ResponseEntity.ok(_jobSeekerSkillService.getByUserId(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeekerSkill jobSeekerSkill){
        return ResponseEntity.ok(_jobSeekerSkillService.add(jobSeekerSkill));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(JobSeekerSkill jobSeekerSkill){
        return ResponseEntity.ok(_jobSeekerSkillService.delete(jobSeekerSkill));
    }
}
