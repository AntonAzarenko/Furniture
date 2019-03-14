package azarenka.web;

import azarenka.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static azarenka.web.DetailController.URL;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = URL + "/file")
public class FileController {

    @Autowired
    private FileService service;

    String fileName = "";

    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String message;

        try {
            service.upload(file);
            fileName = file.getOriginalFilename();
            message = "Successfully upload file" + file.getOriginalFilename();
        } catch (Exception e) {
            message = "Error upload file" + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping(value = "/abort")
    public void abort() {
        service.abort(fileName);
    }
}
