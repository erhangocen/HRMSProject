package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.ISystemUserService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/systemUsers/")
public class SystemUserController {

    private ISystemUserService _systemUserService;

    @Autowired
    public SystemUserController(ISystemUserService _systemUserService) {
        this._systemUserService = _systemUserService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_systemUserService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody SystemUser systemUser){
        return ResponseEntity.ok(_systemUserService.add(systemUser));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(SystemUser systemUser){
        return ResponseEntity.ok(_systemUserService.delete(systemUser));
    }

}
