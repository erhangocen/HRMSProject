package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IPhotoService;
import kodlamaio.humanResourcesProject.business.abstracts.IUserService;
import kodlamaio.humanResourcesProject.core.uploadService.imageUplad.ImageUploaderService;
import kodlamaio.humanResourcesProject.core.utilities.results.*;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IPhotoDao;
import kodlamaio.humanResourcesProject.entities.concretes.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class PhotoManager implements IPhotoService {

    private IPhotoDao _photoDao;
    private ImageUploaderService _imageUploaderService;
    private IUserService _userService;

    @Autowired
    public PhotoManager(IPhotoDao photoDao, ImageUploaderService imageUploaderService, IUserService userService) {
        this._photoDao = photoDao;
        this._imageUploaderService = imageUploaderService;
        this._userService = userService;
    }

    @Override
    public Result add(Photo photo) {
        _photoDao.save(photo);
        return new SuccessResult();
    }

    @Override
    public Result update(int userId, MultipartFile multipartFile) {
        Map<String,String> uploadImage = _imageUploaderService.uploadImageFile(multipartFile).getData();
        Photo photo = _photoDao.findByUserId(userId);
        photo.setPhotoUrl(uploadImage.get("url"));
        _photoDao.save(photo);
        return new SuccessResult("yes");
    }

    @Override
    public Result delete(Photo photo) { //photo id sistemine gecilebilir
        photo.setPhotoUrl("https://res.cloudinary.com/dbzf16o0x/image/upload/v1657832793/Ec6ferCXYAA6XB__ednbzx.jpg");
        _photoDao.save(photo);
        return new SuccessResult();
    }

    @Override
    public DataResult<Photo> getByUserId(int id) {
        return new SuccessDataResult<Photo>(_photoDao.findByUserId(id));
    }
}
