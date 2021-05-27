package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IJobPositionService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions/")
public class JobPositionsController {

    private final IJobPositionService _jobPositionService;

    @Autowired
    public JobPositionsController(IJobPositionService _jobPositionService) {
        this._jobPositionService = _jobPositionService;
    }

    @GetMapping("getall")
    public DataResult<List<JobPosition>> getAll(){
        return _jobPositionService.getAll();
    }
}
