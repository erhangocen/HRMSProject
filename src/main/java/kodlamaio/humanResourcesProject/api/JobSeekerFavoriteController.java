package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerFavoriteService;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerFavorite;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobSeekerFavorite/")
@CrossOrigin
public class JobSeekerFavoriteController {
    private IJobSeekerFavoriteService _jobSeekerFavoriteService;

    @Autowired
    public JobSeekerFavoriteController(IJobSeekerFavoriteService jobSeekerFavoriteService) {
        this._jobSeekerFavoriteService = jobSeekerFavoriteService;
    }

    @GetMapping("getByUserId")
    public ResponseEntity<?> getByUserId(int id){
        return ResponseEntity.ok(_jobSeekerFavoriteService.getByUserId(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeekerFavorite jobSeekerFavorite){
        return ResponseEntity.ok(_jobSeekerFavoriteService.add(jobSeekerFavorite));
    }

    @PostMapping("delete")
    public ResponseEntity<?> delete(@RequestBody JobSeekerFavorite jobSeekerFavorite){
        return ResponseEntity.ok(_jobSeekerFavoriteService.delete(jobSeekerFavorite));
    }
}
