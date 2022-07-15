package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobAdvertisementService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/jobAdvertisement/")
public class JobAdvertisementController {
    private IJobAdvertisementService _jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(IJobAdvertisementService jobAdvertisementService) {
        this._jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(_jobAdvertisementService.add(jobAdvertisement));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(_jobAdvertisementService.delete(jobAdvertisement));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_jobAdvertisementService.getAll());
    }

    @GetMapping("getActiveAdvertisements")
    public ResponseEntity<?> getActiveAdvertisements(){
        return ResponseEntity.ok(_jobAdvertisementService.getActiveAdvertisements());
    }

    @GetMapping("getActiveAdvertisementsByEmployer")
    public ResponseEntity<?> getActiveAdvertisementsByEmployer(@RequestParam int employerId){
        return ResponseEntity.ok(_jobAdvertisementService.getActiveAdvertisementsByEmployer(employerId));
    }

    @PostMapping("advertisementActiveFalse")
    public ResponseEntity<?> advertisementActiveFalse(@RequestParam int id){
        return ResponseEntity.ok(_jobAdvertisementService.advertisementActiveFalse(id));
    }

    @PostMapping("advertisementActiveTrue")
    public ResponseEntity<?> advertisementActiveTrue(@RequestParam int id){
        return ResponseEntity.ok(_jobAdvertisementService.advertisementActiveTrue(id));
    }

    @GetMapping("getActiveAdvertisementsByDeadlineAsc")
    public ResponseEntity<?> getActiveAdvertisementsByDeadlineAsc(){
        return ResponseEntity.ok(_jobAdvertisementService.getActiveAdvertisementsByDeadlineAsc());
    }

    @GetMapping("getActiveAdvertisementsByDeadlineDesc")
    public ResponseEntity<?> getActiveAdvertisementsByDeadlineDesc(){
        return ResponseEntity.ok(_jobAdvertisementService.getActiveAdvertisementsByDeadlineDesc());
    }
}
