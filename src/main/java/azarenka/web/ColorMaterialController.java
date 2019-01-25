package azarenka.web;

import azarenka.entity.DetailsColor;
import azarenka.service.ColorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static azarenka.web.DetailController.URL;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = URL + "/color")
public class ColorMaterialController {

    @Autowired
    private ColorDetailService service;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DetailsColor> getAll() {
        return service.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable("id")Long id){
        service.delete(id);
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(DetailsColor detailsColor){
        service.save(detailsColor);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DetailsColor get(@PathVariable("id")Long id){
        return service.getByID(id);
    }


}
