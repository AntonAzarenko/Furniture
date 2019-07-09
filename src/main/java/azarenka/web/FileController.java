package azarenka.web;

import azarenka.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static azarenka.web.DetailController.URL;

/**
 * Edge controller.
 * <p>
 * Copyright (C) 2018 Anton_Azarenka@epam.com
 * </p>
 * Date: 7/9/18
 *
 * @author Anton Azarenka
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = URL + "/file")
public class FileController {

    @Autowired
    private FileService service;

    String fileName = "";

    /**
     * Uploads file.
     *
     * @param file file.
     * @return Responce entity.
     */
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

    /**
     * Aborts changes if upload file failed
     *
     */
    @GetMapping(value = "/abort")
    public void abort() {
        service.abort(fileName);
    }
}
