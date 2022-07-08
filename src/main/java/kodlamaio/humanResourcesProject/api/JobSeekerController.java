package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/jobseekers/")
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

    @PostMapping("add")
    public ResponseEntity<?> add(JobSeeker jobSeeker) throws Exception{
        return ResponseEntity.ok(_jobSeekerService.getAll());
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(JobSeeker jobSeeker){
        return ResponseEntity.ok(_jobSeekerService.delete(jobSeeker));
    }
}
