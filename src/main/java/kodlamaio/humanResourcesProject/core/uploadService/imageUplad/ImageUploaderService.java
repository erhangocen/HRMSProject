package kodlamaio.humanResourcesProject.core.uploadService.imageUplad;

import java.io.IOException;
import java.util.Map;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploaderService {

    DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
