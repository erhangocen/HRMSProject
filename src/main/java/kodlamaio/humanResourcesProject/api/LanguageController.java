package kodlamaio.humanResourcesProject.api;

import kodlamaio.humanResourcesProject.business.abstracts.ILanguageService;
import kodlamaio.humanResourcesProject.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/language/")
public class LanguageController {

    private ILanguageService _languageService;

    @Autowired
    public LanguageController(ILanguageService languageService) {
        this._languageService = languageService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_languageService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody Language language){
        return ResponseEntity.ok(_languageService.add(language));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody Language language){
        return ResponseEntity.ok(_languageService.delete(language));
    }
}
