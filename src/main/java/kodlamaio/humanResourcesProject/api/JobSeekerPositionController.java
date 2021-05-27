package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerPositionService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekerpositions/")
public class JobSeekerPositionController {

    private IJobSeekerPositionService _jobSeekerPositionService;

    @Autowired
    public JobSeekerPositionController(IJobSeekerPositionService _jobSeekerPositionService) {
        this._jobSeekerPositionService = _jobSeekerPositionService;
    }

    @GetMapping("getall")
    public DataResult<List<JobSeekerPosition>> getAll(){
        return _jobSeekerPositionService.getAll();
    }

    @PostMapping("add")
    public Result add(JobSeekerPosition jobSeekerPosition){
        return _jobSeekerPositionService.add(jobSeekerPosition);
    }
}
