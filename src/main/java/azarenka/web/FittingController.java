package azarenka.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static azarenka.web.DetailController.URL;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping(value = URL +"/fitting")
public class FittingController {

    @PostMapping()
    public void updateFile(@RequestBody MultipartFile file) {
            file.getSize();
    }
}
