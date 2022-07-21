package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.Photo;
import org.springframework.web.multipart.MultipartFile;

public interface IPhotoService {
    Result add(Photo photo);
    Result update(int userId, MultipartFile multipartFile);
    Result delete(Photo photo);

    DataResult<Photo> getByUserId(int id);
}
