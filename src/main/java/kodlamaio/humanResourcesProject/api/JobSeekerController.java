package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobseekers/")
public class JobSeekerController {

    private IJobSeekerService _jobSeekerService;

    @Autowired
    public JobSeekerController(IJobSeekerService _jobSeekerService) {
        this._jobSeekerService = _jobSeekerService;
    }

    @GetMapping("getall")
    public DataResult<List<JobSeeker>> getAll(){
        return _jobSeekerService.getAll();
    }

    @PostMapping("add")
    public Result add(JobSeeker jobSeeker){
        return _jobSeekerService.add(jobSeeker);
    }
}
