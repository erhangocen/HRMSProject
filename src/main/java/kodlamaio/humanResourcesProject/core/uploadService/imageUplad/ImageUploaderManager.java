package kodlamaio.humanResourcesProject.core.uploadService.imageUplad;

import java.io.IOException;
import java.util.Map;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.ErrorDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class ImageUploaderManager implements ImageUploaderService{


    private Cloudinary cloudinary;

    @Autowired
    public ImageUploaderManager(Cloudinary cloudinary) {

        this.cloudinary =cloudinary;
    }

    @Override
    public DataResult<Map> uploadImageFile(MultipartFile imageFile) {

        try {
            @SuppressWarnings("unchecked")
            Map<String,String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());

            return new SuccessDataResult<Map>(resultMap);
        } catch (IOException e) {

            e.printStackTrace();
        }

        return new ErrorDataResult<Map>("Cannot added !");
    }

}