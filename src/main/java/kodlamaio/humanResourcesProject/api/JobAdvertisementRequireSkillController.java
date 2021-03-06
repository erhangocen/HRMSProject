package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobAdvertisementRequireSkillService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisement;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisementRequireSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisementRequireSkill/")
@CrossOrigin
public class JobAdvertisementRequireSkillController {
    private IJobAdvertisementRequireSkillService _jobAdvertisementRequireSkillService;

    @Autowired
    public JobAdvertisementRequireSkillController(IJobAdvertisementRequireSkillService jobAdvertisementRequireSkillService) {
        this._jobAdvertisementRequireSkillService = jobAdvertisementRequireSkillService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisementRequireSkill jobAdvertisementRequireSkill){
        return ResponseEntity.ok(_jobAdvertisementRequireSkillService.add(jobAdvertisementRequireSkill));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody JobAdvertisementRequireSkill jobAdvertisementRequireSkill){
        return ResponseEntity.ok(_jobAdvertisementRequireSkillService.delete(jobAdvertisementRequireSkill));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_jobAdvertisementRequireSkillService.getAll());
    }

    @GetMapping("getBySkillId")
    public ResponseEntity<?> getBySkillId(@RequestParam int id){
        return ResponseEntity.ok(_jobAdvertisementRequireSkillService.getBySkillId(id));
    }

    @GetMapping("getByJobAdvertisementsId")
    public ResponseEntity<?> getByJobAdvertisementsId(@RequestParam int id){
        return ResponseEntity.ok(_jobAdvertisementRequireSkillService.getByJobAdvertisementId(id));
    }
}
