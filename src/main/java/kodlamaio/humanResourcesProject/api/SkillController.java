package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.ISkillService;
import kodlamaio.humanResourcesProject.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/skill/")
@CrossOrigin
public class SkillController {
    private ISkillService _skillService;

    @Autowired
    public SkillController(ISkillService skillService) {
        this._skillService = skillService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_skillService.getAll());
    }

    @GetMapping("getNoHaveSkills")
    public ResponseEntity<?> getNoHaveSkills(@RequestParam int userId){
        return ResponseEntity.ok(_skillService.getNoHaveUser(userId));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody Skill skill){
        return ResponseEntity.ok(_skillService.add(skill));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(Skill skill){
        return ResponseEntity.ok(_skillService.delete(skill));
    }
}
