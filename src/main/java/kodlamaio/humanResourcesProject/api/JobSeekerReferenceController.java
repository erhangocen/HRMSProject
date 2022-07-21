package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerReferenceService;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerCertificate;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobSeekerReference/")
@CrossOrigin
public class JobSeekerReferenceController {

    private IJobSeekerReferenceService _jobSeekerReferenceService;

    public JobSeekerReferenceController(IJobSeekerReferenceService jobSeekerReferenceService) {
        this._jobSeekerReferenceService = jobSeekerReferenceService;
    }

    @GetMapping("getByUserId")
    public ResponseEntity<?> getByUserId(@RequestParam int id){
        return ResponseEntity.ok(_jobSeekerReferenceService.getAllReferencesByUserId(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeekerReference jobSeekerReference){
        return ResponseEntity.ok(_jobSeekerReferenceService.add(jobSeekerReference));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody JobSeekerReference jobSeekerCertificate){
        return ResponseEntity.ok(_jobSeekerReferenceService.add(jobSeekerCertificate));
    }
}
