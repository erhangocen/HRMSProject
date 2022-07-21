package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerLanguageService;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobSeekerLanguage/")
@CrossOrigin
public class JobSeekerLanguageController {

    private IJobSeekerLanguageService _jobSeekerLanguageService;

    @Autowired
    public JobSeekerLanguageController(IJobSeekerLanguageService jobSeekerLanguageService) {
        this._jobSeekerLanguageService = jobSeekerLanguageService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_jobSeekerLanguageService.getAll());
    }

    @GetMapping("getByUserId")
    public ResponseEntity<?> getByUserId(int id){
        return ResponseEntity.ok(_jobSeekerLanguageService.getByUserId(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeekerLanguage jobSeekerLanguage){
        return ResponseEntity.ok(_jobSeekerLanguageService.add(jobSeekerLanguage));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody JobSeekerLanguage jobSeekerLanguage){
        return ResponseEntity.ok(_jobSeekerLanguageService.delete(jobSeekerLanguage));
    }
}
