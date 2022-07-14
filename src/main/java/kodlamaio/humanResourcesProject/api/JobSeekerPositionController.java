package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerPositionService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobSeekerPositions/")
public class JobSeekerPositionController {

    private IJobSeekerPositionService _jobSeekerPositionService;

    @Autowired
    public JobSeekerPositionController(IJobSeekerPositionService _jobSeekerPositionService) {
        this._jobSeekerPositionService = _jobSeekerPositionService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_jobSeekerPositionService.getAll());
    }

    @GetMapping("getByUserId")
    public ResponseEntity<?> getByUserId(int id){
        return ResponseEntity.ok(_jobSeekerPositionService.getByUserId(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody JobSeekerPosition jobSeekerPosition){
        return ResponseEntity.ok(_jobSeekerPositionService.add(jobSeekerPosition));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody JobSeekerPosition jobSeekerPosition){
        return ResponseEntity.ok(_jobSeekerPositionService.delete(jobSeekerPosition));
    }
}
