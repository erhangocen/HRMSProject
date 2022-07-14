package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobPositionService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPositions/")
public class JobPositionsController {

    private final IJobPositionService _jobPositionService;

    @Autowired
    public JobPositionsController(IJobPositionService _jobPositionService) {
        this._jobPositionService = _jobPositionService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_jobPositionService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody JobPosition jobPosition){
        return ResponseEntity.ok(_jobPositionService.add(jobPosition));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody JobPosition jobPosition){
        return ResponseEntity.ok(_jobPositionService.delete(jobPosition));
    }
}
