package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.IPhotoService;
import kodlamaio.humanResourcesProject.entities.concretes.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/photo/")
@CrossOrigin
public class PhotoController {
    private IPhotoService _photoService;

    @Autowired
    public PhotoController(IPhotoService photoService) {
        this._photoService = photoService;
    }

    @GetMapping("getByUserId")
    public ResponseEntity<?> getByUserId(int id){
        return ResponseEntity.ok(_photoService.getByUserId(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestParam(value = "userId") int userId,@Valid @RequestParam(value = "imageFile") MultipartFile photoFile) {
        return ResponseEntity.ok(_photoService.update(userId,photoFile));
    }

    @PostMapping("delete")
    public ResponseEntity<?> delete(@RequestBody Photo photo) {
        return ResponseEntity.ok(_photoService.delete(photo));
    }
}
