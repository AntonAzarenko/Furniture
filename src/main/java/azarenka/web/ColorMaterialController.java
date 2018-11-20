package azarenka.web;

import azarenka.entity.ColorDetail;
import azarenka.exceptions.NotFoundException;
import azarenka.service.ColorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "color")
public class ColorMaterialController {

    @Autowired
    private ColorDetailService service;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ColorDetail> getAll() {
        return service.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable("id")Long id){
        service.delete(id);
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(ColorDetail colorDetail){
        service.save(colorDetail);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ColorDetail get(@PathVariable("id")Long id){
        return service.getByID(id);
    }


}
