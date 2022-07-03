package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IUserService;
import kodlamaio.humanResourcesProject.core.utilities.results.*;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IEmailValidationDao;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IUserDao;
import kodlamaio.humanResourcesProject.entities.concretes.EmailValidation;
import kodlamaio.humanResourcesProject.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements IUserService {

    private IUserDao _userDao;
    private IEmailValidationDao _emailValidationDao;

    public UserManager(IUserDao userDao, IEmailValidationDao emailValidationDao) {
        this._userDao = userDao;
        this._emailValidationDao = emailValidationDao;
    }

    @Override
    public DataResult<User> getByUserId(int id) {
        return new SuccessDataResult<User>(_userDao.findById(id).get());
    }

    @Override
    public DataResult<List<User>> getAllUser() {
        return new SuccessDataResult<List<User>>(_userDao.findAll());
    }

    @Override
    public Result checkEmail(User user) {
        List<User> users = _userDao.findByEmail(user.getEmail());
        if (users.isEmpty()){
            return new SuccessResult();
        }
        return new ErrorResult("this email already exists in system");
    }

    @Override
    public Result validate(EmailValidation emailValidation) {
        _emailValidationDao.save(emailValidation);
        return new SuccessResult();
    }

}
