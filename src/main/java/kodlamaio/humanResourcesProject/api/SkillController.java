package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.ISkillService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerSkill;
import kodlamaio.humanResourcesProject.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill/")
public class SkillController {
    private ISkillService _skillService;

    @Autowired
    public SkillController(ISkillService skillService) {
        this._skillService = skillService;
    }

    @GetMapping("getAll")
    public DataResult<List<Skill>> getAll(){
        return _skillService.getAll();
    }

    @PostMapping("add")
    public Result add(Skill skill){
        return _skillService.add(skill);
    }

    @DeleteMapping("delete")
    public Result delete(Skill skill){
        return _skillService.delete(skill);
    }
}
