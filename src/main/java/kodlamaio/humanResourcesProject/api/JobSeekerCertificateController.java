package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerCertificateService;
import kodlamaio.humanResourcesProject.entities.concretes.JobPosition;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobSeekerCertificate/")
@CrossOrigin
public class JobSeekerCertificateController {
    private IJobSeekerCertificateService _jobSeekerCertificateService;

    @Autowired
    public JobSeekerCertificateController(IJobSeekerCertificateService jobSeekerCertificateService) {
        this._jobSeekerCertificateService = jobSeekerCertificateService;
    }

    @GetMapping("getByUserId")
    public ResponseEntity<?> getByUserId(@RequestParam int id){
        return ResponseEntity.ok(_jobSeekerCertificateService.getAllCertificatesByUserId(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeekerCertificate jobSeekerCertificate){
        return ResponseEntity.ok(_jobSeekerCertificateService.add(jobSeekerCertificate));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody JobSeekerCertificate jobSeekerCertificate){
        return ResponseEntity.ok(_jobSeekerCertificateService.delete(jobSeekerCertificate));
    }
}
