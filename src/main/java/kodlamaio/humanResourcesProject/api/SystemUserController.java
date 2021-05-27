package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.ISystemUserService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/systemusers/")
public class SystemUserController {

    private ISystemUserService _systemUserService;

    @Autowired
    public SystemUserController(ISystemUserService _systemUserService) {
        this._systemUserService = _systemUserService;
    }

    @GetMapping("getall")
    public DataResult<List<SystemUser>> getAll(){
        return _systemUserService.getAll();
    }

    @PostMapping("add")
    public Result add(SystemUser systemUser){
        return _systemUserService.add(systemUser);
    }

}
