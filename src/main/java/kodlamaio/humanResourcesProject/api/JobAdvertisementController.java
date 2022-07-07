package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobAdvertisementService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import kodlamaio.humanResourcesProject.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return _jobAdvertisementService.add(jobAdvertisement);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestBody JobAdvertisement jobAdvertisement){
        return _jobAdvertisementService.delete(jobAdvertisement);
    }

    @GetMapping("getAll")
    public DataResult<List<JobAdvertisement>> getAll(){
        return _jobAdvertisementService.getAll();
    }
}
