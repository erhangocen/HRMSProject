package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerSchoolService;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobSeekerSchool/")
@CrossOrigin
public class JobSeekerSchoolController {

    private IJobSeekerSchoolService _jobSeekerSchoolService;

    @Autowired
    public JobSeekerSchoolController(IJobSeekerSchoolService jobSeekerSchoolService) {
        this._jobSeekerSchoolService = jobSeekerSchoolService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_jobSeekerSchoolService.getAll());
    }

    @GetMapping("getByUserId")
    public ResponseEntity<?> getByUserId(int id){
        return ResponseEntity.ok(_jobSeekerSchoolService.getByUserId(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeekerSchool jobSeekerSchool){
        return ResponseEntity.ok(_jobSeekerSchoolService.add(jobSeekerSchool));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody JobSeekerSchool jobSeekerSchool){
        return ResponseEntity.ok(_jobSeekerSchoolService.delete(jobSeekerSchool));
    }
}
