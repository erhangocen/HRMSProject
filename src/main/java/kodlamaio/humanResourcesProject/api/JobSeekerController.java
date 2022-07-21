package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;
import kodlamaio.humanResourcesProject.entities.dtos.JobSeekerLinksDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/jobSeeker/")
@CrossOrigin
public class JobSeekerController {

    private IJobSeekerService _jobSeekerService;

    @Autowired
    public JobSeekerController(IJobSeekerService _jobSeekerService) {
        this._jobSeekerService = _jobSeekerService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_jobSeekerService.getAll());
    }

    @GetMapping("getCv")
    public ResponseEntity<?> getCv(@RequestParam int userId){
        return ResponseEntity.ok(_jobSeekerService.getCv(userId));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker) throws Exception{
        return ResponseEntity.ok(_jobSeekerService.add(jobSeeker));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody JobSeeker jobSeeker){
        return ResponseEntity.ok(_jobSeekerService.delete(jobSeeker));
    }

    @PostMapping("updateLinks")
    public ResponseEntity<?> updateLinks(@RequestBody JobSeekerLinksDto jobSeekerLinksDto){
        return ResponseEntity.ok(_jobSeekerService.updateLinks(jobSeekerLinksDto));
    }

    @PostMapping("updateCoverLetter")
    public ResponseEntity<?> updateCoverLetter(@RequestParam int userId,@RequestParam String coverLetter){
        return ResponseEntity.ok(_jobSeekerService.updateCoverLetter(userId,coverLetter));
    }
}
