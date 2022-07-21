package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerExperienceService;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobSeekerExperience/")
@CrossOrigin
public class JobSeekerExperienceController {

    private IJobSeekerExperienceService _jobSeekerExperienceService;

    @Autowired
    public JobSeekerExperienceController(IJobSeekerExperienceService jobSeekerExperienceService) {
        this._jobSeekerExperienceService = jobSeekerExperienceService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_jobSeekerExperienceService.getAll());
    }

    @GetMapping("getByUserId")
    public ResponseEntity<?> getByUserId(int id){
        return ResponseEntity.ok(_jobSeekerExperienceService.getByUserId(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeekerExperience jobSeekerExperience){
        return ResponseEntity.ok(_jobSeekerExperienceService.add(jobSeekerExperience));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody JobSeekerExperience jobSeekerExperience){
        return ResponseEntity.ok(_jobSeekerExperienceService.delete(jobSeekerExperience));
    }
}
