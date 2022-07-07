package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IUserService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import kodlamaio.humanResourcesProject.entities.concretes.SystemUser;
import kodlamaio.humanResourcesProject.entities.concretes.User;
import org.apache.axis.constants.Use;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    private IUserService _userService;

    @Autowired
    public UserController(IUserService _userService) {
        this._userService = _userService;
    }

    @GetMapping("getAll")
    public DataResult<List<User>> getAll(){
        return _userService.getAllUser();
    }

    @GetMapping("getById")
    public DataResult<User> getById(@RequestBody int id){
        return _userService.getByUserId(id);
    }

    @PostMapping("validation")
    public Result validation(@RequestBody EmailValidation emailValidation){
        return _userService.validate(emailValidation);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestBody User user){
        return _userService.delete(user);
    }
}